package school.faang.task_59980;

import java.util.function.Supplier;

public class ErrorHandler extends RuntimeException {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandling.handle(e);
        }
    }
}