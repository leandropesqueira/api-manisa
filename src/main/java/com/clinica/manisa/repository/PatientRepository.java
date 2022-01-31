package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
