package handlingerrorsgracefully;

import java.util.function.Supplier;

public class ErrorHandle {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
