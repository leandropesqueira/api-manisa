package com.clinica.manisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Specialty implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NonNull
    @NotEmpty
    private String name;      
    
    @OneToMany(mappedBy = "specialty")
    private List<Doctor> doctors = new ArrayList<>();
   
    
}
