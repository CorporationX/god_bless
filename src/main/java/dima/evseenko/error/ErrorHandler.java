package dima.evseenko.error;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> action, Function<Exception, T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
