package school.faang.spint2.task46302error;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
