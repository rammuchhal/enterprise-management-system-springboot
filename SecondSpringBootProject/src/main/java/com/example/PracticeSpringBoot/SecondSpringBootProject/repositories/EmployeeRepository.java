package com.example.PracticeSpringBoot.SecondSpringBootProject.repositories;

import com.example.PracticeSpringBoot.SecondSpringBootProject.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {


}
