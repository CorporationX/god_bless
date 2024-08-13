package faang.school.godbless.BJS2_21108;

import java.util.function.Supplier;

public class Error {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
