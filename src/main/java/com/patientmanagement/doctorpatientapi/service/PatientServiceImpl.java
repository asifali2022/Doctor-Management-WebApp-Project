package com.patientmanagement.doctorpatientapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patientmanagement.doctorpatientapi.dto.DoctorDto;
import com.patientmanagement.doctorpatientapi.dto.PatientDto;
import com.patientmanagement.doctorpatientapi.entity.Doctor;
import com.patientmanagement.doctorpatientapi.entity.Patient;
import com.patientmanagement.doctorpatientapi.exception.PatientNotFoundException;
import com.patientmanagement.doctorpatientapi.mapper.DoctorMapper;
import com.patientmanagement.doctorpatientapi.mapper.PatientMapper;
import com.patientmanagement.doctorpatientapi.repository.DoctorRepository;
import com.patientmanagement.doctorpatientapi.repository.PatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtos = new ArrayList<>();
        for (Patient patient : patients) {
            patientDtos.add(PatientMapper.maptoPatientDto(patient));
        }
        return patientDtos;
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            return PatientMapper.maptoPatientDto(optionalPatient.get());
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.maptoPatient(patientDto);
        patient = (Patient) patientRepository.save(patient);
        return PatientMapper.maptoPatientDto(patient);
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<DoctorDto> suggestDoctors(Long patientId) {
        Patient patient = getPatientEntityById(patientId);
        List<Doctor> doctors = getDoctorsByPatientLocationAndSymptom(patient);

        if (doctors.isEmpty()) {
            handleNoDoctorFound(patient);
        }

        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDtos.add(DoctorMapper.mapToDoctorDto(doctor));
        }
        return doctorDtos;
    }

    private Patient getPatientEntityById(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new PatientNotFoundException("Patient not found");
        }
    }

    private List<Doctor> getDoctorsByPatientLocationAndSymptom(Patient patient) {
        String speciality = getSpecialityFromSymptom(patient.getSymptom());
        List<Doctor> allDoctors = doctorRepository.findAll();
        List<Doctor> matchingDoctors = new ArrayList<>();

        for (Doctor doctor : allDoctors) {
            if (doctor.getCity().equals(patient.getCity()) &&
                doctor.getSpeciality().equalsIgnoreCase(speciality)) {
                matchingDoctors.add(doctor);
            }
        }
        return matchingDoctors;
    }

    private void handleNoDoctorFound(Patient patient) {
        List<String> supportedCities = List.of("Delhi", "Noida", "Faridabad");

        if (!supportedCities.contains(patient.getCity())) {
            throw new RuntimeException("We are still waiting to expand to your location");
        } else {
            throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
        }
    }

    private String getSpecialityFromSymptom(String symptom) {
        switch (symptom.toLowerCase()) {
            case "arthritis":
            case "back pain":
            case "tissue injuries":
                return "Orthopedic";
            case "dysmenorrhea":
                return "Gynecology";
            case "skin infection":
            case "skin burn":
                return "Dermatology";
            case "ear pain":
                return "ENT";
            default:
                return "";
        }
    }

}
