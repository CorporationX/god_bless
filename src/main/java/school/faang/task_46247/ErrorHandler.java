package school.faang.task_46247;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ExceptionThrowingSupplier<T> action, Function<Exception, T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
