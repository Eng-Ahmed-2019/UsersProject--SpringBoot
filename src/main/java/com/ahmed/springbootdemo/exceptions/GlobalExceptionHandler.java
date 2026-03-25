//package com.ahmed.springbootdemo.exceptions;
/*
import  java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
*/
/*
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<Map<String, String>>> handleValidationErrors
            (MethodArgumentNotValidException ex) {

        List<Map<String, String>> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {

            Map<String, String> errorDetails = new HashMap<>();

            errorDetails.put("field", error.getField());
            errorDetails.put("message", error.getDefaultMessage());

            errors.add(errorDetails);
        }

        return Map.of("errors", errors);
    }
}
*/

package com.ahmed.springbootdemo.exceptions;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<ValidationError>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        List<ValidationError> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(
                    error.getField(),
                    error.getDefaultMessage()
            ));
        }

        return Map.of("errors", errors);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> handleNotFound(NoSuchElementException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleGeneralError(Exception ex) {
        return Map.of("error", "Something went wrong");
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public Map<String, String> handleMultipleExceptions(Exception ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleGeneralException(Exception ex) {
        return new ApiError("Internal Server Error", 500, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleValidationErrorss(MethodArgumentNotValidException ex) {

        List<ValidationError> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(
                    error.getField(),
                    error.getDefaultMessage()
            ));
        }

        return new ApiError("Validation Failed", 400, errors);
    }
}