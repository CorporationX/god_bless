package school.faang.task_46464;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(Callable<T> method, Function<Exception, T> exceptionHandler) {
        try {
            return method.call();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
