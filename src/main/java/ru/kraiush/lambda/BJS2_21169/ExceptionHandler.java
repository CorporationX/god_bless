package ru.kraiush.lambda.BJS2_21169;

@FunctionalInterface
public interface ExceptionHandler<T, R, E extends Exception> {

    R apply(T t) throws E;

}



