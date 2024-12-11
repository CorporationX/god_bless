package school.faang.spring2.task_46211;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandle<T> handle) {

        try {
            return supplier.get();
        } catch (Exception e) {
            return handle.handle(e);
        }

    }
}
