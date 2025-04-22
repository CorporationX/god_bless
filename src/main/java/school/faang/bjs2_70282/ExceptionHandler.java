package school.faang.bjs2_70282;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
