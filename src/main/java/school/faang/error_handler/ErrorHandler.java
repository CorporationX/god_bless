package school.faang.error_handler;

public class ErrorHandler {
    public static void withErrorHandling(Runnable action,
                                         ExceptionHandler<Void> errorHandler) {
        try {
            action.run();
        } catch (Exception e) {
            errorHandler.handle(e);
        }
    }
}
