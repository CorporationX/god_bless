package ru.kraiush.spring.BJS2_27254.exception;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(final String message) {
        super(message);
    }

    public ElementNotFoundException(final String message, Throwable cause) {
        super(message, cause);
    }

}
