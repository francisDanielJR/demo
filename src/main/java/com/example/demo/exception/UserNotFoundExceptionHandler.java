package com.example.demo.exception;

public class UserNotFoundExceptionHandler extends RuntimeException {

    public UserNotFoundExceptionHandler(String id) {
        super(String.format("User not found", id));
    }
    
}
