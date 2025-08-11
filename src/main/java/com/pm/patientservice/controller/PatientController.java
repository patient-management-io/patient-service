package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping()
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        List<PatientResponseDto> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping()
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patient = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(patient);
    }
}
