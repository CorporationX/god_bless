package school.faang.errorhandling;

import java.util.function.Supplier;

public class ErrorExample {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandling.error(e);
        }
    }
}