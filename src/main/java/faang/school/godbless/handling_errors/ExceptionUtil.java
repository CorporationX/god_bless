package faang.school.godbless.handling_errors;

import java.util.function.Supplier;

public class ExceptionUtil {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return errorHandling.handle(exception);
        }
    }
}
