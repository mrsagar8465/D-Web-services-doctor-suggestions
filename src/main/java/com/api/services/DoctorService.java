package com.api.services;

import java.util.List;

import com.api.entities.Doctor;

import jakarta.validation.Valid;

public interface DoctorService 
{

	void saveDoctor(@Valid Doctor doctor);

	Doctor getById(int did);

	List<Doctor> getByCity(String city);

	Doctor deleteById(int did);

}
