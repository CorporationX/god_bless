package school.faang.errorhandling;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Supplier<String> connection = () -> RemoteService.call("connection string");
        Supplier<String> error = () -> RemoteService.call("no connection");
        ExceptionHandler<String> withException = exception -> {
            log.info("Ошибка при вызове сервиса");
            return "DEFAULT";
        };

        log.info(ErrorHandler.withErrorHandling(connection, withException));
        log.info(ErrorHandler.withErrorHandling(error, withException));
    }

    public static class ErrorHandler {
        public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                return exceptionHandler.handle(exception);
            }
        }
    }

    public static class RemoteService {
        public static String call(String value) {
            if (!value.equals("connection string")) {
                throw new RuntimeException("Сервис недоступен");
            }
            return "Подключение к сервису успешно";
        }
    }
}