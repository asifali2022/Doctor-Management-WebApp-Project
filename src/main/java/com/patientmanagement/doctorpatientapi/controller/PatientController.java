package com.patientmanagement.doctorpatientapi.controller;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.dto.PatientDto;
import com.patientmanagement.doctorpatientapi.exception.PatientNotFoundException;
import com.patientmanagement.doctorpatientapi.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

//Configuring context path to '/myapp'
// This ensures that the application is accessible under the '/myapp' context

public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
   
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        try {
            PatientDto patient = patientService.getPatientById(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
   
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto) {
        PatientDto addedPatient = patientService.addPatient(patientDto);
        return new ResponseEntity<>(addedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
  
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/suggest-doctors")
   
    public ResponseEntity<List<DoctorDto>> suggestDoctors(@PathVariable Long id) {
        try {
            List<DoctorDto> suggestedDoctors = patientService.suggestDoctors(id);
            return new ResponseEntity<>(suggestedDoctors, HttpStatus.OK);
        } catch (PatientNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
