package com.example.PracticeSpringBoot.SecondSpringBootProject.dto;

import com.example.PracticeSpringBoot.SecondSpringBootProject.annotations.EmployeePasswordValidation;
import com.example.PracticeSpringBoot.SecondSpringBootProject.annotations.EmployeePrimeNoValidation;
import com.example.PracticeSpringBoot.SecondSpringBootProject.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @Positive
    private Long id;

    @Size(min=3,max=16,message="The name must be in this range")
    private String name;

    @Min(value=18)
    @Max(value=70)
    private Integer age;

    @Email
    private String email;

    @PastOrPresent
    private LocalDate joiningDate;

    @DecimalMax(value="999999.99")
    @DecimalMin(value="800.00")
    @Digits(integer = 6,fraction=2)
    private Double salary;

    @NotBlank
    @EmployeePasswordValidation
    private String password;

    @AssertTrue
    private Boolean isActive;

    @EmployeePrimeNoValidation
    private Integer primeNo;

    @EmployeeRoleValidation
    @NotBlank
    private String role;

    @Pattern(regexp = "^[6-9]\\d{9}$",message = "Phone number not valid")
    private String phoneNo;
}
