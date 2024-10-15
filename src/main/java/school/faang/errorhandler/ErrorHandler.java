package school.faang.errorhandler;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get(); // Execute the main action
        } catch (Exception e) {
            return errorHandler.handle(e); // Handle the exception and return the result
        }
    }
}

