package school.faang.task_46239;

public class ErrorHandler {
    public static <T> T withErrorHandling(CheckSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
