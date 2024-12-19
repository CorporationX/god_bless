package school.faang.bjs246297;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplierMainAction, ExceptionalHandler<T> errorHandling) {
        if (supplierMainAction == null || errorHandling == null) {
            log.error("Action or errorHandler cannot be null");
            throw new IllegalArgumentException("Action and errorHandler must not be null");
        }
        try {
            T result = supplierMainAction.get();
            log.info("The action was completed successfully.");
            return result;
        } catch (Exception e) {
            log.warn("Runtime error: {}", e.getMessage());
            return errorHandling.handle(e);
        }
    }
}