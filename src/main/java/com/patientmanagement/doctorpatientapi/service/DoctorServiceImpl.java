package com.patientmanagement.doctorpatientapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.entity.Doctor;
import com.patientmanagement.doctorpatientapi.mapper.DoctorMapper;
import com.patientmanagement.doctorpatientapi.repository.DoctorRepository;


@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

 
    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDtos.add(DoctorMapper.mapToDoctorDto(doctor));
        }
        return doctorDtos;
    }

    
    @Override
    public DoctorDto getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            return DoctorMapper.mapToDoctorDto(optionalDoctor.get());
        } else {
            throw new RuntimeException("Doctor not found");
        }
    }

   
    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = DoctorMapper.mapToDoctor(doctorDto);
        doctor = (Doctor) doctorRepository.save(doctor);
        return DoctorMapper.mapToDoctorDto(doctor);
    }

    /**
     * Deletes a doctor by ID.
     *
     * @param id the ID of the doctor to be deleted
     */
    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

	
}
