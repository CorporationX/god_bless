package school.faang.task_46488;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(ThrowingSupplier<T> action,
                                          Function<Exception, T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
