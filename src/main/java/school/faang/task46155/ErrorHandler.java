package school.faang.task46155;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> serviceSupplier,
                                          ErrorHandling<T> errorHandling) {
        validate(serviceSupplier, errorHandling);

        try {
            return serviceSupplier.get();
        } catch (Exception e) {
            return errorHandling.handleError(e);
        }
    }

    private static <T> void validate(Supplier<T> serviceSupplier,
                                     ErrorHandling<T> errorHandling) {
        if (serviceSupplier == null) {
            throw new IllegalArgumentException("serviceSupplier is null");
        }
        if (errorHandling == null) {
            throw new IllegalArgumentException("errorHandling is null");
        }
    }
}
