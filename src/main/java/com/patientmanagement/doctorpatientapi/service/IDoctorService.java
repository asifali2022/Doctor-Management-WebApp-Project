package com.patientmanagement.doctorpatientapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;

@Service
public interface IDoctorService {

	public List<DoctorDto> getAllDoctors();
	
	public DoctorDto getDoctorById(Long id);
	
	public DoctorDto addDoctor(DoctorDto doctorDto);
	
	public void deleteDoctor(Long id);
}
