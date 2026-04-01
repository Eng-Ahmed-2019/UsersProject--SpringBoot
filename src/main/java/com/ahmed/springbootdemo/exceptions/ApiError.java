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

    public ApiError apiError() {
        return new ApiError("Default message", 500, null);
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

/*
@Component
public class ApiError {
    private String message;
    private int status;
    private Object errors;

    public ApiError() {} // no-args constructor

    // setters
    public void setMessage(String message) { this.message = message; }
    public void setStatus(int status) { this.status = status; }
    public void setErrors(Object errors) { this.errors = errors; }

    // getters
}
 */