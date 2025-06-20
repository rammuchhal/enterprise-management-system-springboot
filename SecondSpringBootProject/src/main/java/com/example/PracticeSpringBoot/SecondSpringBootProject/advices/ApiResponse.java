package com.example.PracticeSpringBoot.SecondSpringBootProject.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

   private T data;
   private LocalDateTime timeStamp;
   private ApiError error;

   public ApiResponse(){
       this.timeStamp=LocalDateTime.now();
   }

   public ApiResponse(T data){
       this();
       this.data=data;
   }
   public ApiResponse(ApiError apiError){
       this();
       this.error=apiError;
   }
}
