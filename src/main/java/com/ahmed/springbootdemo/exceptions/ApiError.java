package com.ahmed.springbootdemo.exceptions;

public class ApiError {
    private String message;
    private int status;
    private Object errors;

    public ApiError(String message, int status, Object errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Object getErrors() {
        return errors;
    }
}