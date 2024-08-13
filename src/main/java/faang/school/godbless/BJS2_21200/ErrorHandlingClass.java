package faang.school.godbless.BJS2_21200;

import java.util.function.Supplier;

public class ErrorHandlingClass {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.handlingException(e);
        }
    }
}
