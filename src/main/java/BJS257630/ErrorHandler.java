package BJS257630;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> primaryAction, ExceptionHandler exceptionAction) {
        try {
            return primaryAction.get();
        } catch (Exception e) {
            return (T) exceptionAction.handle(e);
        }
    }
}
