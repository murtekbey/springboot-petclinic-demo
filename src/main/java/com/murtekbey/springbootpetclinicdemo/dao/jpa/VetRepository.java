package com.murtekbey.springbootpetclinicdemo.dao.jpa;

import com.murtekbey.springbootpetclinicdemo.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
