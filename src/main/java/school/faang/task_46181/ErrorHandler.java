package school.faang.task_46181;

public class ErrorHandler<T> {

    public static <T> T withErrorHandling(ThrowingExceptionSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception ex) {
            return errorHandler.handle(ex);
        }
    }
}
