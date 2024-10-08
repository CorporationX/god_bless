package school.faang.handleerrors;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(ExceptionHandler<T> errorHandler, Function<Exception, T> function) {
        try {
            return errorHandler.handle();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}