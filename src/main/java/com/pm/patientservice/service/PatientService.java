package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDto).toList();
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDto));
        return PatientMapper.toDto(patient);
    }
}
