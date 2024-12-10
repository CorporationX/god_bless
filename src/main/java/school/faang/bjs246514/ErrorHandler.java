package school.faang.bjs246514;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier,
                                          ExceptionSupplier<T> exceptionSupplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionSupplier.handle(e);
        }
    }

}
