package com.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor
{
	@Id
    @GeneratedValue(generator ="doc_seq")
	@SequenceGenerator(name ="doc_seq",initialValue =101,allocationSize =1)
	private int did;
	
	@Size(min =3,message ="Name must have atleast three characters")
	@Pattern(regexp ="[a-zA-Z ' '.]*",message ="only alphabets and space is allowed in name")
	@NotNull(message ="Name is required")
	private String name;
	@Pattern(regexp = "Delhi|Noida|Ghaziabad",message ="City is not valid")
	@Size(max =20,message ="maximum length of the city should be 20")
	@NotNull(message ="City is required")
	private String city;
	@NotNull(message ="Email is required")
	@Email(message ="Email is invalid")
	private String email;
	@NotNull(message ="Phone is required")
	@Size(min =10,message ="phone number must have atleast 10 digits")
	@Pattern(regexp ="[0-9]*",message ="only digits allowed in the phone number")
	private String phone;
	@Pattern(regexp ="Orthopedic|Gynecology|Dermatology|ENT",message= "Speciality is not valid")
	@NotNull(message ="Speciality is required")
	private String speciality;  
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
