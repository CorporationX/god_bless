package handleErrorsBeautifully;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(CheckedSupplier<T> supplier, Function<Exception, T> function) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
