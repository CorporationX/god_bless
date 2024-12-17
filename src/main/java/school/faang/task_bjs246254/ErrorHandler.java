package school.faang.task_bjs246254;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> function) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            return function.handle(e);
        }
    }
}


