package com.clinica.manisa.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clinica.manisa.domain.Specialty;
import com.clinica.manisa.dto.SpecialtyDTO;
import com.clinica.manisa.service.SpecialtyService;

@RestController
@RequestMapping(value = "/specialties")
public class SpecialtyResource {

	@Autowired
	private SpecialtyService specialtyService;	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Specialty> insert(@Valid @RequestBody Specialty obj){
		obj = specialtyService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
	@GetMapping
	public ResponseEntity<List<SpecialtyDTO>> listAll(){
		List<Specialty> list = specialtyService.findAll();
		List<SpecialtyDTO> listDTO = list.stream().map(obj -> new SpecialtyDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Specialty> findById(@PathVariable Long id){
		Specialty obj = specialtyService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SpecialtyDTO> update(@PathVariable Long id, @Valid @RequestBody SpecialtyDTO objDTO){
		Specialty newObj = specialtyService.update(id, objDTO);
		return ResponseEntity.ok().body(new SpecialtyDTO(newObj));		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		specialtyService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
