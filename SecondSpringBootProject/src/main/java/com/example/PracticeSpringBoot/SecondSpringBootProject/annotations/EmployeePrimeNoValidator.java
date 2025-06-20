package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeePrimeNoValidator implements ConstraintValidator<EmployeePrimeNoValidation,Integer> {

    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
        if(num<2) return false;
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
