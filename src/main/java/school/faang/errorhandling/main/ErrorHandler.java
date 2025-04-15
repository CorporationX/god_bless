package school.faang.errorhandling.main;

import java.util.function.Supplier;

@FunctionalInterface
public interface ErrorHandler<T> {
    T handler(Exception e);

    static <T> T withErrorHandling(Supplier<T> action, ErrorHandler<T> handle) {
        try {
            return action.get();
        } catch (Exception e) {
            return handle.handler(e);
        }
    }
}