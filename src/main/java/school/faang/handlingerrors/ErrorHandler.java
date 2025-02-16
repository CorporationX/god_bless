package school.faang.handlingerrors;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, Function<Exception, T> function) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            return function.apply(e);
        }
    }
}