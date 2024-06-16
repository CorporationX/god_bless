package faang.school.godbless.sprint2.exceptionHandling;

import java.util.Optional;

public class ExceptionUtils {

    public static <T> Optional<T> withErrorHandling(CheckedExceptionSupplier<T> service, ExceptionHandler<T> exceptionHandler) {
        try {
            return Optional.of(service.get());
        } catch (Exception e) {
            return exceptionHandler.handleError(e);
        }
    }
}
