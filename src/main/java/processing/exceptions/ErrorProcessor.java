package processing.exceptions;

import java.util.Objects;
import java.util.function.Supplier;

public class ErrorProcessor {
    public static <T> T withErrorHandling(Supplier<T> supplier, ServiceCallable<T> serviceCallable) {
        if (Objects.isNull(supplier) || Objects.isNull(supplier)) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        try {
            return supplier.get();
        } catch (Exception e) {
            return serviceCallable.returnDefault(e);
        }
    }
}
