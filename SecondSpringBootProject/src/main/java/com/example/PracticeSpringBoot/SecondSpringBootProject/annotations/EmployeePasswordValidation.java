package com.example.PracticeSpringBoot.SecondSpringBootProject.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.METHOD})
@Constraint(validatedBy = {EmployeePasswordValidator.class})
public @interface EmployeePasswordValidation {
    String message() default "{jakarta.validation.constraints.AssertTrue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
