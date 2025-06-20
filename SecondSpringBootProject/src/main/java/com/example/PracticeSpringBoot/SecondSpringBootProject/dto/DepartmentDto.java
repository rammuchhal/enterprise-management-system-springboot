package com.example.PracticeSpringBoot.SecondSpringBootProject.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @Positive
    private Long id;

    @NotBlank
    @Size(min=2,max=20)
    private String title;

    @AssertTrue
    private Boolean isActive;

    @DecimalMin(value = "99.99")
    @DecimalMax(value ="999999.99")
    private Double deptSalary;


    private LocalDateTime createdAt;
}
