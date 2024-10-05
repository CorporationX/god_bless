package ru.kraiush.spring.BJS2_27254.exception;

public class MemberException extends RuntimeException {

    public MemberException(final String message) {
        super(message);
    }

    public MemberException(final String message, Throwable cause) {
        super(message, cause);
    }

}
