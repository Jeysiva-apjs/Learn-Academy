package com.jey.learnacademy.exception;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(String email){
        super("Could not find admin with email " + email + ".");
    }

    public AdminNotFoundException(Long id){
        super("Could not find admin with id " + id + ".");
    }

    
}
