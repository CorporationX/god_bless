package school.faang.handlingerrors;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (RuntimeException e) {
            return handler.handle(e);
        }
    }
}
