package com.vukkumsp.imagemodifier.exceptions;

public class IncorrectEffectException extends RuntimeException {
    String message;

    public IncorrectEffectException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
