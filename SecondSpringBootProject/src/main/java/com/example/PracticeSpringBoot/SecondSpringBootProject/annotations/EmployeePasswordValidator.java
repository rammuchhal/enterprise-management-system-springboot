package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeePasswordValidator implements ConstraintValidator<EmployeePasswordValidation,String> {
    private static final String specialSymbols ="!@#$%^&*()-+=<>?/{}~|\\/";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if(password.length()<10) return false;

        Boolean hasUpper=false;
        Boolean hasLower=false;
        Boolean hasSpecial=false;

        for(char c:password.toCharArray()){
            if(Character.isUpperCase(c)) hasUpper=true;
            if(Character.isLowerCase(c)) hasLower=true;
            if(specialSymbols.contains(String.valueOf(c))) hasSpecial=true;
        }
        return (hasUpper && hasLower && hasSpecial);
    }
}
