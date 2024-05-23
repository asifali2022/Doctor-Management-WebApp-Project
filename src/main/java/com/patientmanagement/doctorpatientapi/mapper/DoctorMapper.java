package com.patientmanagement.doctorpatientapi.mapper;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.entity.Doctor;

public class DoctorMapper {

	 public static DoctorDto mapToDoctorDto(Doctor doctor) {
	        return new DoctorDto(
	                doctor.getId(),
	                doctor.getName(),
	                doctor.getCity(),
	                doctor.getEmail(),
	                doctor.getPhoneNumber(),
	                doctor.getSpeciality()
	        );
	    }

	    public static Doctor mapToDoctor(DoctorDto doctorDto) {
	        return new Doctor(
	                doctorDto.getId(),
	                doctorDto.getName(),
	                doctorDto.getCity(),
	                doctorDto.getEmail(),
	                doctorDto.getPhoneNumber(),
	                doctorDto.getSpeciality()
	        );
	    }
}
