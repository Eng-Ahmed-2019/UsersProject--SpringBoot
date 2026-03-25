package com.ahmed.springbootdemo.exceptions;

import lombok.Getter;

@Getter
public class ValidationError {
    private String Field, Message;

    public ValidationError(String f, String m) {
        this.Field = f;
        this.Message = m;
    }
}