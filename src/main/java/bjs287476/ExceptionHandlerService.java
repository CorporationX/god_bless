package bjs287476;

import java.util.function.Supplier;

public class ExceptionHandlerService {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.withErrorHandling(e);
        }
    }
}
