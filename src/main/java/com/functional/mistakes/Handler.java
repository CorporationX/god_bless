package com.functional.mistakes;

import java.util.function.Supplier;

public class Handler {

    public static <T> T withErrorHandling(ExceptionHandler<Exception> errorHandling, Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            errorHandling.handle(exception);
        }
        return null;
    }
}
