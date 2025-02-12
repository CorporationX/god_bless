package school.faang.bjs2_57504;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> action, Function<Exception, T> handler) {
        T result;
        try {
            result = action.get();
        } catch (Exception e) {
            result = handler.apply(e);
        }
        return result;
    }
}
