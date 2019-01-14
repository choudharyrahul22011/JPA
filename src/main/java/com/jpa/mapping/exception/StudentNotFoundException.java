package com.jpa.mapping.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message){
        super(message);
    }
}
