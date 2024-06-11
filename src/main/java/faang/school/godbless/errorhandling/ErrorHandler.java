package faang.school.godbless.errorhandling;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            exceptionHandler.handle(e);
            return null;
        }
    }
}
