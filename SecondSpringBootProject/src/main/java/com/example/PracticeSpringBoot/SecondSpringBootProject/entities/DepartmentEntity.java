package com.example.PracticeSpringBoot.SecondSpringBootProject.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Department",uniqueConstraints = {
        @UniqueConstraint(name="titleMustBeUnique",columnNames = {"title"})
})
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean isActive;

    private Double deptSalary;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
