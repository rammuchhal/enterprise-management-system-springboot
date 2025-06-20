package com.example.PracticeSpringBoot.SecondSpringBootProject.repositories;

import com.example.PracticeSpringBoot.SecondSpringBootProject.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
