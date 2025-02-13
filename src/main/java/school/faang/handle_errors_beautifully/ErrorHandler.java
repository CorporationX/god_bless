package school.faang.handle_errors_beautifully;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Supplier;

public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
    public static final String NULL_PARAM_ERROR = "Param cannot be null";

    public static <T> T withErrorHanding(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        Objects.requireNonNull(action, NULL_PARAM_ERROR);
        Objects.requireNonNull(errorHandler, NULL_PARAM_ERROR);
        try {
            return action.get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return errorHandler.handle(e);
        }
    }
}
