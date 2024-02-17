package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.entities.Doctor;
import com.api.services.DoctorService;

import jakarta.validation.Valid;

@Controller
@ResponseBody
@RequestMapping("doctor-suggestion")
public class DoctorController
{
   @Autowired
   private DoctorService doctorService;
   
   @PostMapping("add")
   public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor)
   {
	   System.out.println("add doctor api called....");
	   doctorService.saveDoctor(doctor);
	   return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
   }
   @GetMapping("details/byid")
   public ResponseEntity<Doctor> getDoctorById(@RequestParam int did)
   {
	   Doctor doctor=doctorService.getById(did);
	   return ResponseEntity.ok(doctor);
}
   @GetMapping("list/bycity")
   public ResponseEntity<List<Doctor>> getDoctorByCity(@RequestParam String city)
   {
	   List<Doctor> doctorList=doctorService.getByCity(city);
	   return ResponseEntity.ok(doctorList);
}
   @DeleteMapping("delete/byid")
   public ResponseEntity<Doctor> deleteDoctorById(@RequestParam int did)
   {
	   Doctor doctor=doctorService.deleteById(did);
	   return ResponseEntity.ok(doctor);
}
}
