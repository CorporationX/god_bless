package school.faang.task57771;

import lombok.NonNull;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(@NonNull Supplier<T> supplier,
                                          @NonNull ExceptionHandler<Exception, T> errorHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandler.callException(e);
        }
    }
}
