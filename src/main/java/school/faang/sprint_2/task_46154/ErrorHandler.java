package school.faang.sprint_2.task_46154;

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