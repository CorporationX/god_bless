package faang.school.godbless.error_handling;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
