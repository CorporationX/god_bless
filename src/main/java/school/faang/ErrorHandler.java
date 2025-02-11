package school.faang;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        validateSupplier(action);
        validateExceptionHandler(handler);
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }

    private static <T> void validateSupplier(Supplier<T> supplier) {
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier can't be null");
        }
    }

    private static <T> void validateExceptionHandler(ExceptionHandler<T> handler) {
        if (handler == null) {
            throw new IllegalArgumentException("ExceptionHandler can't be null");
        }
    }
}
