package com.patientmanagement.doctorpatientapi.exception;

public class DoctorNotFoundException extends RuntimeException {
    /**
	 * 
	 */


	public DoctorNotFoundException(String message) {
        super(message);
    }
}