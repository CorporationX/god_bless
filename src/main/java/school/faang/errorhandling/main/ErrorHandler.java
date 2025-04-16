package school.faang.errorhandling.main;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler<T> {
    static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> handle) {
        try {
            return action.get();
        } catch (Exception e) {
            return handle.apply(e);
        }
    }
}