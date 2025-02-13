package school.faang.BJS2_57639;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> defaultValue) {
        try {
            return action.get();
        } catch (Exception e) {
            return defaultValue.apply(e);
        }
    }
}
