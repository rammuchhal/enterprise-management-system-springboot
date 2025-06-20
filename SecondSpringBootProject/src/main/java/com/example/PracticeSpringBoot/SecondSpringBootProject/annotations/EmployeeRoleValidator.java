package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) {
        if(role==null) return false;
        List<String> roles= List.of("User","Admin","Manager","Ceo");
                return roles.contains(role);
    }
}
