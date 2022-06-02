package com.murtekbey.springbootpetclinicdemo.service;

import com.murtekbey.springbootpetclinicdemo.exception.OwnerNotFoundException;
import com.murtekbey.springbootpetclinicdemo.exception.VetNotFoundException;
import com.murtekbey.springbootpetclinicdemo.model.Owner;
import com.murtekbey.springbootpetclinicdemo.model.Vet;

import java.util.List;

public interface PetClinicService {

    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner(Long id) throws OwnerNotFoundException;
    void createOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Long id);

    List<Vet> findVets();
    Vet findVet(Long id) throws VetNotFoundException;
}
