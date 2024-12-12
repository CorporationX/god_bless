package school.faang.task_46221;

public class ErrorHandler {
    public static void withErrorHandling(Runnable action, ExceptionHandler<Void> errorHandler) {
        try {
            action.run();
        } catch (Exception e) {
            errorHandler.handle(e);
        }
    }
}
