package com.patientmanagement.doctorpatientapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.EnableTransactionManagement;

//Configuring context path to '/myapp'
// This ensures that the application is accessible under the '/myapp' context


@SpringBootApplication
@EnableTransactionManagement

public class DoctorPatientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientApiApplication.class, args);
	}
	
	 
	  
}
