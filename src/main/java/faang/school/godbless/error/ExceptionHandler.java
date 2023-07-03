package main.java.faang.school.godbless.error;

@FunctionalInterface

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
