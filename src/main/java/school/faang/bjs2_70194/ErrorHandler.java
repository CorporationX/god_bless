package school.faang.bjs2_70194;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> actionHandler, ExceptionHandler<T> exceptionHandler) {
        try {
            return actionHandler.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}