package faang.school.godbless.exception;

import java.util.function.Supplier;

public class ExceptionProcessor {
    static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
