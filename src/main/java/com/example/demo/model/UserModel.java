package com.example.demo.model;

import jakarta.validation.Valid;

@Valid
public class UserModel {
    
    private String firstName;
    private String lastName;
    private String email;

    
    public UserModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
