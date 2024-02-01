package com.jey.learnacademy.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(Long id){
        super("Could not find course with id " + id + ".");
    }
    
}
