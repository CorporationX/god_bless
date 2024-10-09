package bjs2_33389;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        T result;

        try {
            result = supplier.get();
        } catch (Exception e) {
            result = exceptionHandler.handle(e);
        }
        return result;
    }
}
