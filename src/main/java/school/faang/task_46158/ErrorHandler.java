package school.faang.task_46158;

import java.util.concurrent.Callable;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.call();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
