package ru.kraiush.lambda.BJS2_21169;

import java.util.function.Function;

public class ErrorHandler {

    public static <T, R, E extends Exception> Function<T, R> rethrowFunction(ExceptionHandler<T, R, E> function) throws E  {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception exception) {
                throwActualException(exception);
                return null;
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <E extends Exception> void throwActualException(Exception exception) throws E {
        throw (E) exception;
    }
}