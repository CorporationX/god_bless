package school.faang.bjs246186;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> work, Function<Exception, T> handling) {
        if (work == null || handling == null) {
            throw new IllegalArgumentException("Argunemnt must be not null !!!");
        }

        try {
            return work.get();
        } catch (Exception e) {
            return handling.apply(e);
        }
    }
}
