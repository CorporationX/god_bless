package school.faang;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> action, ExeptionHandler<T> errorHandler) {
        try {
            return action.get();

        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
