package com.patientmanagement.doctorpatientapi.mapper;

import com.patientmanagement.doctorpatientapi.dto.PatientDto;
import com.patientmanagement.doctorpatientapi.entity.Patient;

public class PatientMapper {

	public static PatientDto maptoPatientDto (Patient patient)
	{
		return new PatientDto(
				
				patient.getId(),
				patient.getName(),
				patient.getCity(),
				patient.getEmail(),
				patient.getPhoneNumber(),
				patient.getSymptom()
				);
	}
	
	public static Patient maptoPatient (PatientDto patientDto)
	{
		return new Patient(
				
				patientDto.getId(),
				patientDto.getName(),
				patientDto.getCity(),
				patientDto.getEmail(),
				patientDto.getPhoneNumber(),
				patientDto.getSymptom()
				);
	}
}
