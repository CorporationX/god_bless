package ErrorHandler;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, MyExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handleException(e);
        }
    }
}
