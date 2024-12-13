package school.faang.spring2.task_46211;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(ThrowableSupplier<T> supplier, ExceptionHandler<T> handle) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handle.handle(e);
        }

    }
}
