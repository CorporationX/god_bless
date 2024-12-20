package school.faang.task_46207;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.handle(e);
        }
    }
}
