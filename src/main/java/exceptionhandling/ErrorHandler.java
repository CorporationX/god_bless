package exceptionhandling;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainAction, ExceptionHandler<T> errorHandler) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
