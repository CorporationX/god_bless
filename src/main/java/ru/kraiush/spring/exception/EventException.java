package ru.kraiush.spring.exception;

public class EventException extends RuntimeException {

    public EventException(final String message) {
        super(message);
    }

    public EventException(final String message, Throwable cause)	{
        super(message, cause);
    }
    
}
