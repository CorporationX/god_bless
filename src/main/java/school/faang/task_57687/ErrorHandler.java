package school.faang.task_57687;

import lombok.NonNull;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(@NonNull Supplier<T> supplier, @NonNull ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return handler.processing(exception);
        }
    }
}
