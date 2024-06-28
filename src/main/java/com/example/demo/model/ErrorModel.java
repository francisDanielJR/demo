package com.example.demo.model;

public class ErrorModel {

    private String title;
    private String status;
    private String errors;
    
    public ErrorModel(String title, String status, String errors) {
        this.title = title;
        this.status = status;
        this.errors = errors;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getErrors() {
        return errors;
    }
    public void setErrors(String errors) {
        this.errors = errors;
    }
    
    @Override
    public String toString() {
        return "ErrorModel [title=" + title + ", status=" + status + ", errors=" + errors + "]";
    }
    
}
