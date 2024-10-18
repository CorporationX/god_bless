package school.faang.pretty.error.handling;

import java.util.function.Function;

public class ErrorHandler {
    @FunctionalInterface
    interface CheckedSupplier<T> {
        T get() throws Exception;
    }

    public static <T> T withErrorHandling(CheckedSupplier<T> action, Function<Exception, T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
