package com.vukkumsp.imagemodifier.exceptions;

public class GlobalException extends RuntimeException {

    public GlobalException(String string) {
    }

    public String getMessage(){
        return "Global Exception";
    }
    
}
