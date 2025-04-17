package school.faang.stream2.exceptionshandler;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainSupplier, ExceptionHandler<T> defaultSupplier) {
        try {
            return mainSupplier.get();
        } catch (Exception e) {
            return defaultSupplier.handleException(e);
        }
    }
}
