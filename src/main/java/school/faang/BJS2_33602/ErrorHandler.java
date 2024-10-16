package school.faang.BJS2_33602;

import java.util.function.Supplier;

public class ErrorHandler {
    public static  <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
