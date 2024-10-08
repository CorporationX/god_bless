package school.faang.handle_exceptions_gracefully;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            //Attempt to perform the action
            return action.get();
        } catch (Exception e) {
            //Delegate the exception handling to the custom handler
            return errorHandler.handle(e);
        }
    }
}