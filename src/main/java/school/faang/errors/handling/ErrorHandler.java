package school.faang.errors.handling;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> mainAction, Function<Exception, T> exceptionHandler) {
        validate(mainAction, exceptionHandler);
        try {
            return mainAction.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }

    private static <T> void validate(ThrowingSupplier<T> mainAction, Function<Exception, T> exceptionHandler) {
        if (mainAction == null) {
            throw new IllegalArgumentException("mainAction не может быть null");
        }
        if (exceptionHandler == null) {
            throw new IllegalArgumentException("exceptionHandler не может быть null");
        }
    }
}
