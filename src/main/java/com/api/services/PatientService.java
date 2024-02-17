package com.api.services;

import java.util.List;

import com.api.entities.Doctor;
import com.api.entities.Patient;

public interface PatientService 
{
     void savePatient(Patient patient);
     List<Doctor> getDoctorListByPid(int pid);
}
