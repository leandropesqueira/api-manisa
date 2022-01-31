package com.clinica.manisa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long>{
	
}