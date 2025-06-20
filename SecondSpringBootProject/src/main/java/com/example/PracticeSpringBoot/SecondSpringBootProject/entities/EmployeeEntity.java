package com.example.PracticeSpringBoot.SecondSpringBootProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private LocalDate joiningDate;
    private Double salary;
    private Boolean isActive;
    private Integer primeNo;
    private String role;
    private String password;
    private String phoneNo;
}
