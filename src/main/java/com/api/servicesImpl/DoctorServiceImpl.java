package com.api.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.Doctor;
import com.api.exception.DoctorNotFoundException;
import com.api.repositories.DoctorRepository;
import com.api.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService 
{
	@Autowired
     private DoctorRepository doctorRepository;
	
	public void saveDoctor(Doctor doctor)
	{
		doctorRepository.save(doctor);
	}
	public Doctor getById(int did) 
	{
		Doctor doctor= doctorRepository.findById(did).orElse(null);
		if(doctor==null)
		{
			DoctorNotFoundException ex=new DoctorNotFoundException("Doctor with id "+did+" not found." );
			throw ex;
		}
		return doctor;
	}
	
	public List<Doctor> getByCity(String city) 
	{
		List<Doctor> list=doctorRepository.findByCity(city);
		if(list.isEmpty())
	{
			DoctorNotFoundException ex=new DoctorNotFoundException("No doctor found in the city" );
			throw ex;
	}
		return list;
	}
	
	public Doctor deleteById(int did)
	{
	    Doctor doctor=doctorRepository.findById(did).orElse(null);
	    if(doctor==null)
		{
				DoctorNotFoundException ex=new DoctorNotFoundException("No doctor found in the city" );
				throw ex;
		}
	    doctorRepository.deleteById(did);
		return doctor;
	}
}
