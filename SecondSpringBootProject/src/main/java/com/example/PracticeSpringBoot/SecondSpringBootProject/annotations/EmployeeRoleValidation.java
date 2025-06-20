package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
    String message() default "Employee Role is Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
