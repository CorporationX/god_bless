package school.faang.bjs2_71710;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ExceptionSupplier<T> errorSupplier, Function<Exception, T> errorHandler) {
        try {
            return errorSupplier.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
