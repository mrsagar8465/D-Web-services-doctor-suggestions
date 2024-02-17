package com.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Pattern;

@Entity
public class Patient 
{
     @Id
     @GeneratedValue(generator ="pat_seq")
     @SequenceGenerator(name = "pat_seq",initialValue = 1111,allocationSize = 1)
     private int pid;
     private String name;
     private String city;
     private String email;
     private String phone;
     private String symptom;
     @Pattern(regexp = "Arthritis|Backpain|Tissue Injuries|Dysmenorrhea|Skin infection|skin burn|Ear pain|throat sore",message = "Invalid Symptom")
     
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
}
     
     
     

