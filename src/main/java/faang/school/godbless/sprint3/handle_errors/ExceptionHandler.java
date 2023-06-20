package faang.school.godbless.sprint3.handle_errors;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);

    static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
