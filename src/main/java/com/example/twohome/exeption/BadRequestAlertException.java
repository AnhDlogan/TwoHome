package com.example.twohome.exeption;

public class BadRequestAlertException extends Throwable{
    public BadRequestAlertException() {
    }

    public BadRequestAlertException(String message) {
        super(message);
    }
}
