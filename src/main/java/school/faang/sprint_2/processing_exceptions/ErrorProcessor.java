package school.faang.sprint_2.processing_exceptions;

import java.util.Objects;
import java.util.function.Supplier;

public class ErrorProcessor {
    public static <T> T withErrorHandling(Supplier<T> supplier, ErrorFallback<T> errorFallback) {
        if (Objects.isNull(supplier) || Objects.isNull(supplier)) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorFallback.returnDefault(e);
        }
    }
}
