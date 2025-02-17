package errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Supplier;

public class ErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        Objects.requireNonNull(action, "Основное действие (action) не должно быть null");
        Objects.requireNonNull(exceptionHandler, "Обработчик ошибок (exceptionHandler) не должен быть null");
        try {
            return action.get();
        } catch (Exception e) {
            logger.error("Ошибка при выполнении действия: ", e);
            return exceptionHandler.handleException(e);
        }
    }
}
