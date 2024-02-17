package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>
{
   
}
