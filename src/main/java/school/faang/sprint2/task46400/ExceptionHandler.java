package school.faang.sprint2.task46400;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);

    static <T> T withErrorHandling(Supplier<T> doAction, ExceptionHandler<T> errorHandler) {
        try {
            return doAction.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
