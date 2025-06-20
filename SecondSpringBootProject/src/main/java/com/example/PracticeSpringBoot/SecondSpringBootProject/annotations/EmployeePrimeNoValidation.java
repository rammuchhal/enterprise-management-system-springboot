package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeePrimeNoValidator.class})
public @interface EmployeePrimeNoValidation {
    String message() default "{jakarta.validation.constraints.AssertTrue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
