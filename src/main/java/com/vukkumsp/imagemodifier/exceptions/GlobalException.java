package com.vukkumsp.imagemodifier.exceptions;

public class GlobalException extends RuntimeException {

    String message;

    public GlobalException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
    
}
