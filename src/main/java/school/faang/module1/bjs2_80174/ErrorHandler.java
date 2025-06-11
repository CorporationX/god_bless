package school.faang.module1.bjs2_80174;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        if (action == null) {
            throw new IllegalArgumentException("action не должен быть null");
        }
        if (errorHandler == null) {
            throw new IllegalArgumentException("errorHandler не должен быть null");
        }
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}