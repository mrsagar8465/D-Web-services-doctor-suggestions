package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Doctor;
import com.api.entities.Patient;
import com.api.services.PatientService;

@RestController
@RequestMapping("doctor-suggestion/patient")
public class PatientController 
{
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)
	{
		
		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	   @GetMapping("doctor-list/bypid")
      public ResponseEntity<List<Doctor>> getDoctorListByPatientId(@RequestParam int pid)
      {
    	  
    	  List<Doctor> doctorList=patientService.getDoctorListByPid(pid);
    	  return ResponseEntity.ok(doctorList);
	
}
}