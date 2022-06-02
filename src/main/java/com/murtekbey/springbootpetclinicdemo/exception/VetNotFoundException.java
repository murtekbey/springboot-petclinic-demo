package com.murtekbey.springbootpetclinicdemo.exception;

public class VetNotFoundException extends RuntimeException {

    public VetNotFoundException(String message) {
        super(message);
    }
}
