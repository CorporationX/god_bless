package school.faang.handle_errors_BJS2_33421;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainAction, ExceptionHandler<T> handler) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return handler.handleException(e);
        }
    }
}
