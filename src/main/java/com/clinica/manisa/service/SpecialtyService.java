package com.clinica.manisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.manisa.domain.Specialty;
import com.clinica.manisa.dto.SpecialtyDTO;
import com.clinica.manisa.repository.SpecialtyRepository;
import com.clinica.manisa.service.exceptions.DataIntegrityViolationException;
import com.clinica.manisa.service.exceptions.ObjectNotFoundException;

@Service
public class SpecialtyService {
	
	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	public List<Specialty> findAll(){
		return specialtyRepository.findAll();
	}
	
	public Specialty findById(Long id) {
		Optional<Specialty> obj = specialtyRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id + 
				"Type: " + Specialty.class.getName()));
	}
	
	public Specialty insert(Specialty obj) {
		obj.setId(null);
		return specialtyRepository.save(obj);
	}

	public Specialty update(Long id, SpecialtyDTO objDTO) {
		Specialty obj = findById(id);
		obj.setName(objDTO.getName());
		return specialtyRepository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			specialtyRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Specialty cannot be deleted! Has associated doctors.");
		}
	}

}
