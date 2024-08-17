package faang.school.godbless.lambda.exceptions;

import java.util.function.Supplier;

public class ExceptionUtil {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Throwable throwable) {
            return errorHandler.handle(throwable);
        }
    }
}
