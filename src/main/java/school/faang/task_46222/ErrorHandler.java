package school.faang.task_46222;

public class ErrorHandler {
    public static <T, V> T withErrorHandling(RiskyAction<T, V, Exception> riskyAction,
                                             ExceptionHandler<T> errorHandler, V v) {
        try {
            return riskyAction.call(v);
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
