package com.clinica.manisa.dto;

import java.io.Serializable;

import com.clinica.manisa.domain.Specialty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpecialtyDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public SpecialtyDTO(Specialty obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}
	
	

}
