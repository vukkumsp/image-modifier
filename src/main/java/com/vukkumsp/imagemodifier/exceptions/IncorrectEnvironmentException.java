package com.vukkumsp.imagemodifier.exceptions;

public class IncorrectEnvironmentException extends RuntimeException {
    String message;

    public IncorrectEnvironmentException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
