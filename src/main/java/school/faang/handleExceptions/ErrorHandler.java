package school.faang.handleExceptions;

import java.util.function.Supplier;

public class ErrorHandler {
    public <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
