package main.java.faang.school.godbless.sprint3_lambda.error;

@FunctionalInterface

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
