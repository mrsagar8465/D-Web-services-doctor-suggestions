package com.api.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.Doctor;
import com.api.entities.Patient;
import com.api.exception.DoctorNotFoundException;
import com.api.exception.PatientNotFoundException;
import com.api.repositories.DoctorRepository;
import com.api.repositories.PatientRepository;
import com.api.services.PatientService;
import com.api.util.SymptomSpeciality;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired
     private PatientRepository patientRepository;

	@Autowired
    private DoctorRepository doctorRepository;

		public void savePatient(Patient patient)
	{
	    patientRepository.save(patient);   	
	}

	public List<Doctor> getDoctorListByPid(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElse(null);
		if(patient==null)
		{
			throw new PatientNotFoundException("Patient with id "+pid+"does not exist");
		}
		String city=patient.getCity();
		if(!city.equals("Delhi") && !city.equals("Noida") && !city.equals("Ghaziabad"))
		{
			throw new DoctorNotFoundException("We are still waiting to expand to your location");
		}
		String symptom=patient.getSymptom();
		String speciality=SymptomSpeciality.map.get(symptom);
		List<Doctor> doctorList=doctorRepository.getListBySymptom(city,speciality);
		if(doctorList.isEmpty())
		{
			throw new DoctorNotFoundException("there isn't any docter present at your location");
		}
     	return doctorList;
	}
}
