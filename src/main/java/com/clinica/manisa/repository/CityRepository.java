package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
