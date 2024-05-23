package com.patientmanagement.doctorpatientapi.service;

import java.util.List;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.dto.PatientDto;

public interface IPatientService {
	
	public List<PatientDto> getAllPatients();
	
	public PatientDto getPatientById(Long id);
	
	public PatientDto addPatient(PatientDto patientDto);
	
	public void deletePatient(Long id);
	
	public List<DoctorDto> suggestDoctors(Long patientId);
}
