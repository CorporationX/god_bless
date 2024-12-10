package school.faang.task_46222;

import java.util.concurrent.Callable;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> riskyAction, ExceptionHandler<T> errorHandler) {
        try {
            return riskyAction.call();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
