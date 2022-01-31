package com.clinica.manisa.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.manisa.domain.Specialty;
import com.clinica.manisa.repository.SpecialtyRepository;

@Service
public class DBService {
	
	 @Autowired
	    private SpecialtyRepository specialtyRepository;

	    public void instanceDataBase(){
	        Specialty sp1 = new Specialty(null, "Pediatra");
	        Specialty sp2 = new Specialty(null, "Ginecologista");
	        Specialty sp3 = new Specialty(null, "Psiquiatra");
	        Specialty sp4 = new Specialty(null, "Clínico Geral");

	        this.specialtyRepository.saveAll(Arrays.asList(sp1, sp2, sp3,sp4));
	    }

}
