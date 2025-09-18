package school.faang.error.handler;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> mainAction, Function<RuntimeException, T> errorAction) {
        try {
            return mainAction.get();
        } catch (RuntimeException exception) {
            return errorAction.apply(exception);
        }
    }
}
