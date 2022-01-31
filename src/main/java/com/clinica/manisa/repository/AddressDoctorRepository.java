package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.AddressDoctor;

@Repository
public interface AddressDoctorRepository extends JpaRepository<AddressDoctor, Long>{

}
