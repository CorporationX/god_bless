package school.faang.error_handling;

import java.util.concurrent.Callable;

public class ErrorHandler {
    public static String withErrorHandling(Callable<String> action, ExceptionHandler<String> errorHandler) {
        try {
            return action.call();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
