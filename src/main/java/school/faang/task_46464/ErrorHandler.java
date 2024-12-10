package school.faang.task_46464;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> call, Function<Exception, T> exceptionHandler) {
        try {
            return call.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
