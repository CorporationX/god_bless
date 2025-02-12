package school.faang.errorhandling;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    private static final String CONNECTION_CONDITION = "connection string";
    private static final String MESSAGE_FAILED_CONNECTION = "no connection";

    public static void main(String[] args) {
        Supplier<String> connection = () -> RemoteService.call(CONNECTION_CONDITION);
        Supplier<String> error = () -> RemoteService.call(MESSAGE_FAILED_CONNECTION);
        ExceptionHandler<String> withException = exception -> {
            log.info("Ошибка при вызове сервиса");
            return "DEFAULT";
        };

        log.info(ErrorHandler.withErrorHandling(connection, withException));
        log.info(ErrorHandler.withErrorHandling(error, withException));
    }

    private static class ErrorHandler {
        private static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                log.error(exception.getMessage(), exception);
                return exceptionHandler.handle(exception);
            }
        }
    }

    private static class RemoteService {
        private static String call(String value) {
            if (!value.equals(CONNECTION_CONDITION)) {
                throw new RuntimeException("Сервис недоступен");
            }
            return "Подключение к сервису успешно";
        }
    }
}