package school.faang.exceptions;

import java.util.function.Supplier;

public class ExceptionHandler {
    public <T> T withErrorHandling(Supplier<T> action, ErrorHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
