package school.faang.task216.errorhandler;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainAction,ExceptionHandler<T> exceptionHandler) {
        try {
            return mainAction.get();
        }

        catch (Exception e) {
        return exceptionHandler.getDefault(e);
        }

    }
}
