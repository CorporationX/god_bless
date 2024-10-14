package beautifulErrors;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, Function<Exception, T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
