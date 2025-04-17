package school.faang.handler;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandling<T> exceptionHandling) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return exceptionHandling.handler(exception);
        }
    }
}
