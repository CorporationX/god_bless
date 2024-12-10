package school.faang.task_46158;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.call();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
