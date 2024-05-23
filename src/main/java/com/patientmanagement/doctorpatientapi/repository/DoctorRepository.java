package com.patientmanagement.doctorpatientapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientmanagement.doctorpatientapi.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

	
}
