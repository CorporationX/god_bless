package school.faang.graceful_error_handling;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Action<T> call, Function<Exception, T> errorHandler) {
        try {
            return call.act();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
