package ru.kraiush.spring.BJS2_27254.exception;

public class ElementAlreadyExistsException extends RuntimeException {

    public ElementAlreadyExistsException(final String message) {
        super(message);
    }

    public ElementAlreadyExistsException(final String message, Throwable cause) {
        super(message, cause);
    }

}
