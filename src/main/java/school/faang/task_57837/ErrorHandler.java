package school.faang.task_57837;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainAction, Function<Throwable, T> errorAction) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return errorAction.apply(e);
        }
    }
}
