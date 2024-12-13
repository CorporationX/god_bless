package school.faang.sprint2.bjs_46170;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handleError) {
        try {
            return action.get();
        } catch (Exception e) {
            return handleError.handle(e);
        }
    }
}
