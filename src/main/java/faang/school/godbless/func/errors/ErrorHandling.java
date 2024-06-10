package faang.school.godbless.func.errors;

import java.util.function.Supplier;

public class ErrorHandling {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> fallbackHandler) {
        if (fallbackHandler == null) {
            throw new IllegalArgumentException("Cannot process any action without a handler");
        }
        T result;
        try {
            result = action.get();
        } catch (Exception e) {
            result = fallbackHandler.handle(e);
        }
        return result;
    }
}
