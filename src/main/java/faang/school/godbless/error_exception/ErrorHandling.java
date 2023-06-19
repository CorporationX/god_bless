package faang.school.godbless.error_exception;

import java.util.function.Supplier;

interface ExceptionHandler<T> {
    T handle(Exception ex);
}

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception ex) {
            return exceptionHandler.handle(ex);
        }
    }
}
