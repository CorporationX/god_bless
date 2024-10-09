package dima.evseenko.error;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
