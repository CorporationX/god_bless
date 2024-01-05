package faang.school.godbless.done.error.handler;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> func, ExceptionHandler<T> exception) {
        try {
            return func.get();
        } catch (Exception e) {
            return exception.log(e);
        }
    }
}
