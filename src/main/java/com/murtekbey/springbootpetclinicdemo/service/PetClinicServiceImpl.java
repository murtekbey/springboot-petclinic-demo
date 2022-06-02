package com.murtekbey.springbootpetclinicdemo.service;

import com.murtekbey.springbootpetclinicdemo.dao.OwnerRepository;
import com.murtekbey.springbootpetclinicdemo.dao.PetRepository;
import com.murtekbey.springbootpetclinicdemo.dao.jpa.VetRepository;
import com.murtekbey.springbootpetclinicdemo.exception.OwnerNotFoundException;
import com.murtekbey.springbootpetclinicdemo.exception.VetNotFoundException;
import com.murtekbey.springbootpetclinicdemo.model.Owner;
import com.murtekbey.springbootpetclinicdemo.model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService {

  private OwnerRepository ownerRepository;
  private PetRepository petRepository;
  private JavaMailSender javaMailSender;
  private VetRepository vetRepository;

  @Autowired
  public PetClinicServiceImpl(
      OwnerRepository ownerRepository,
      PetRepository petRepository,
      JavaMailSender javaMailSender,
      VetRepository vetRepository) {
    this.ownerRepository = ownerRepository;
    this.petRepository = petRepository;
    this.javaMailSender = javaMailSender;
    this.vetRepository = vetRepository;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  @Secured(value = {"ROLE_USER", "ROLE_EDITOR"})
  public List<Owner> findOwners() {
    return ownerRepository.findAll();
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  public List<Owner> findOwners(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
  public Owner findOwner(Long id) throws OwnerNotFoundException {
    Owner owner = ownerRepository.findById(id);
    if (owner == null) throw new OwnerNotFoundException("Owner not found with id: " + id);
    return owner;
  }

  @Override
  public void createOwner(Owner owner) {
    ownerRepository.create(owner);

    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom("k@s");
    simpleMailMessage.setTo("m@y");
    simpleMailMessage.setSubject("Owner created!");
    simpleMailMessage.setText("Owner entity with id: " + owner.getId() + " created successfully.");

    javaMailSender.send(simpleMailMessage);
  }

  @Override
  public void updateOwner(Owner owner) {
    ownerRepository.update(owner);
  }

  @Override
  public void deleteOwner(Long id) {
    this.petRepository.deleteByOwnerId(id);
    this.ownerRepository.delete(id);
    //        if(true) throw new RuntimeException("testing rollback");
  }

  @Override
  public List<Vet> findVets() {
    return vetRepository.findAll();
  }

  @Override
  public Vet findVet(Long id) throws VetNotFoundException {
    return vetRepository
        .findById(id)
        .orElseThrow(
            () -> {
              return new VetNotFoundException("Vet not found by id: " + id);
            });
  }
}
