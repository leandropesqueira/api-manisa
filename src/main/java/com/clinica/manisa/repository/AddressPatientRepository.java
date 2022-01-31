package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.AddressPatient;

@Repository
public interface AddressPatientRepository extends JpaRepository<AddressPatient, Long> {

}
