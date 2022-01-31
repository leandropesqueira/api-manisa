package com.clinica.manisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.manisa.domain.Doctor;
import com.clinica.manisa.repository.AddressDoctorRepository;
import com.clinica.manisa.repository.DoctorRepository;
import com.clinica.manisa.service.exceptions.ObjectNotFoundException;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AddressDoctorRepository addressDoctorRepository;
	
	public List<Doctor> findAll(){
		return doctorRepository.findAll();		
	}
	
	@Transactional
	public Doctor insert(Doctor obj) {
		obj.setId(null);
		obj = doctorRepository.save(obj);
		addressDoctorRepository.saveAll(obj.getAdresses());
		return obj;
	}
	
	public Doctor findById(Long id) {
		Optional<Doctor> obj = doctorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id + 
				"Type: " + Doctor.class.getName()));
	}
	
	public Doctor update(Doctor obj) {
		Doctor newObj = findById(obj.getId());
		return doctorRepository.save(newObj);
	}
	
	
	

}
