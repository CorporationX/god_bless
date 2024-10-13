package beautiful.error.handler;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
