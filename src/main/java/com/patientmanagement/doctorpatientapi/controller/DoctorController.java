package com.patientmanagement.doctorpatientapi.controller;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.exception.DoctorNotFoundException;
import com.patientmanagement.doctorpatientapi.service.IDoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")

//Configuring context path to '/myapp'
// This ensures that the application is accessible under the '/myapp' context

public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @GetMapping
    
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
   
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        try {
            DoctorDto doctor = doctorService.getDoctorById(id);
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto addedDoctor = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(addedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
   
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
