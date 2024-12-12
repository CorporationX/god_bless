package school.faang.task_46199;

public class ErrorHandler {

    public static <T> T withErrorHandling(CheckedSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
