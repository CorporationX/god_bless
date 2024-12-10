package school.faang.errorhandling;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling) {
        if (errorHandling == null) {
            throw new RuntimeException("errorHandling cannot be null");
        }
        try {
            return action.get();
        } catch (Exception exception) {
            return errorHandling.handle(exception);
        }
    }
}
