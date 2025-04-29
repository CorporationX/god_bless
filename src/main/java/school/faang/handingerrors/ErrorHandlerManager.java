package school.faang.handingerrors;

import java.util.function.Supplier;

public class ErrorHandlerManager {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
