package school.faang.handleerrors;


public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowableSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return errorHandler.handle(e);
        }
    }
}