package faang.school.godbless.func.errors;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
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
