package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {

    @NotBlank(message = "name is required")
    @Size(max=100, message="Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "date of birth is required")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class,message = "Register date is required")
    private String registerDate;

}
