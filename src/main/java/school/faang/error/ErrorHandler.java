package school.faang.error;

import java.util.Objects;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        checkAction(action);
        checkExceptionHandle(exceptionHandler);

        log.info("Выполнение действия...");

        try {
            T result = action.get();
            log.info("Действие успешно выполнено. Результат: {}", result);
            return result;
        } catch (RuntimeException e) {
            log.error("Произошло исключение при выполнении действия: {}", e.getMessage(), e);
            return exceptionHandler.handle(e);
        }
    }

    private static <T> void checkAction(Supplier<T> action) {
        Objects.requireNonNull(action, "Действие не может быть null");
    }

    private static <T> void checkExceptionHandle(ExceptionHandler<T> exceptionHandler) {
        Objects.requireNonNull(exceptionHandler, "Обработчик не может быть null");
    }
}



