package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.manisa.domain.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Transactional(readOnly = true)
	Doctor findByRegistrationPhysicalPerson(String registrationPhysicalPerson);//CPF

}
