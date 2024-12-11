package school.faang.bjs246171;

public class ErrorHandler {
    public static <T> T withErrorHandling(CheckedSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}