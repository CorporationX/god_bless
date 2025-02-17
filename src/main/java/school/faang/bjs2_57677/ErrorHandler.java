package school.faang.bjs2_57677;

import java.util.function.Supplier;

public class ErrorHandler extends RuntimeException {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
