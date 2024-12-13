package school.faang.sprint_2.task_46201;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
