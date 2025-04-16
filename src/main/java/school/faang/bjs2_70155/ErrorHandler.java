package school.faang.bjs2_70155;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
