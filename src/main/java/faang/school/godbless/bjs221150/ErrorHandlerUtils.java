package faang.school.godbless.bjs221150;

import java.util.function.Supplier;

public class ErrorHandlerUtils {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}