package faang.school.godbless.lambda_stream.error_exception;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception ex) {
            return exceptionHandler.handle(ex);
        }
    }
}