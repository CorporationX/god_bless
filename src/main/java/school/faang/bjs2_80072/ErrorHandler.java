package school.faang.bjs2_80072;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> primaryAction, ExceptionHandler<T> errorHandler) {
        try {
            return primaryAction.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
