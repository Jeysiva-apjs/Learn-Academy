package com.jey.learnacademy.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email){
        super("Could not find user with email " + email + ".");
    }

    public UserNotFoundException(Long id){
        super("Could not find user with id " + id + ".");
    }
    
}
