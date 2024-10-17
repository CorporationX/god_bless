package ru.kraiush.spring.BJS2_27254.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    private String message;

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
