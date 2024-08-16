package faang.school.godbless.BJS2_21128;

import java.util.function.Supplier;

public class ExceptionProcessor {
    public static<T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handleException(e);
        }
    }
}
