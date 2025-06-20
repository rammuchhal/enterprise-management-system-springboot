package com.example.PracticeSpringBoot.SecondSpringBootProject.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
