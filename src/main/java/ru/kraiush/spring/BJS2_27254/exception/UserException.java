package ru.kraiush.spring.BJS2_27254.exception;

public class UserException extends RuntimeException {

    public UserException(final String message) {
        super(message);
    }

    public UserException(final String message, Throwable cause) {
        super(message, cause);
    }
}
