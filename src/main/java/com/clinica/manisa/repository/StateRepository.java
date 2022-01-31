package com.clinica.manisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinica.manisa.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
