package school.faang.sprint_2.processing_exceptions;

import java.util.Objects;
import java.util.function.Supplier;

public class ErrorProcessor {
    public static <T> T withErrorHandling(Supplier supplier, ServiceCallException serviceCallException) {
        if (Objects.isNull(supplier) || Objects.isNull(supplier)) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        try {
            return (T) supplier.get();
        } catch (Exception e) {
            return (T) serviceCallException.returnDefault(e);
        }
    }
}
