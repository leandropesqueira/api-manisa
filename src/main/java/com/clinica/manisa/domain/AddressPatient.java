package com.clinica.manisa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressPatient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String publicPlace;
	private String number;
	private String complement;
	private String district;
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
}
