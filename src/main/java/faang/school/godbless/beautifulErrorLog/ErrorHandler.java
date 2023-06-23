package faang.school.godbless.beautifulErrorLog;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
           return action.get();
        } catch (Exception e) {
            return errorHandler.handleErr(e);
        }
    }
}
