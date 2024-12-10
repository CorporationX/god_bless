package school.faang.task46155;

import lombok.NonNull;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.Callable;

public class ErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    public static <T> T withErrorHandling(@NonNull Callable<T> serviceSupplier,
                                          @NonNull ErrorHandling<T> errorHandling) {
        try {
            return serviceSupplier.call();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return errorHandling.handleError(e);
        }
    }
}
