package com.patientmanagement.doctorpatientapi.dto;




public class DoctorDto {
	
	
	private Long id;
	private String name;
	private String city;
	private String email;
	private String phoneNumber;
	private String speciality;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public DoctorDto() {
		
	}
	
	public DoctorDto(Long id, String name, String city, String email, String phoneNumber, String speciality) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }
	
	

}
