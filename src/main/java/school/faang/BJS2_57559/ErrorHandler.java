package school.faang.BJS2_57559;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        if (action == null || exceptionHandler == null) {
            throw new IllegalArgumentException("Supplier or ExceptionHandler can't be null");
        }

        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
