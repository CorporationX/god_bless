package faang.school.godbless;

import java.util.function.Supplier;

public class RemoteServiceHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
