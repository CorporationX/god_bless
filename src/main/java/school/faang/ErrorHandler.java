package school.faang;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import school.faang.bjs246297.ExceptionalHandler;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

  public static  <T> T withErrorHandling(Supplier<T> supplierMainAction, Function<Exception, T> errorHandling) {
        if (supplierMainAction == null || errorHandling == null){
            logger.error("Action or errorHandler cannot be null");
            throw new IllegalArgumentException("Action and errorHandler must not be null");
        }
        try {
            T result = supplierMainAction.get();
            logger.info("The action was completed successfully.");
            return result;
        } catch (Exception e) {
            logger.warn("Runtime error: {}", e.getMessage());
            return errorHandling.apply(e);
        }
    }
}
