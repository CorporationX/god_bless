package faang.school.godbless.meta.error;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}