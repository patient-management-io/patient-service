package com.pm.patientservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PatientResponseDto {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
}
