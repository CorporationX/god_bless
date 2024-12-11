package school.faang.task_46222;

public class ErrorHandler {
    public static <T> T withErrorHandling(RiskyAction<T, Exception> riskyAction, ExceptionHandler<T> errorHandler) {
        try {
            return riskyAction.call();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
