package ru.kraiush.spring.BJS2_27254.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(final String message) {
        super(message);
    }

    public ResourceAlreadyExistsException(final String message, Throwable cause) {
        super(message, cause);
    }

}
