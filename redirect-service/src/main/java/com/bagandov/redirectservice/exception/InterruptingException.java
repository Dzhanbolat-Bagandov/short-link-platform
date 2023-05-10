package com.bagandov.redirectservice.exception;

public class InterruptingException extends RuntimeException {

    private final String userMessage;

    public InterruptingException(String userMessage) {
        super();
        this.userMessage = userMessage;
    }

    public InterruptingException(String userMessage, String message) {
        super(message);
        this.userMessage = userMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
