package school.faang.errorhandling;

public class ErrorHandler {
    public static <T> T withErrorHandling(CheckedSupplier<T> action, ExceptionHandler<T> errorHandling) {
        if (action == null) {
            throw new CustomExceptionHandler("action cannot be null");
        }
        if (errorHandling == null) {
            throw new CustomExceptionHandler("errorHandling cannot be null");
        }
        try {
            return action.get();
        } catch (Exception exception) {
            return errorHandling.handle(exception);
        }
    }
}
