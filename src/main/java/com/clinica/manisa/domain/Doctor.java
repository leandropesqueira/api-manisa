package com.clinica.manisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String registrationPhysicalPerson; //CPF
	
	@NonNull
	private String regionalMedicineCouncil; //CRM
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<AddressDoctor> adresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "telephone_doctor")
	private Set<String> phones = new HashSet<>();	
	
}
