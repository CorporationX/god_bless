package school.faang.errorhandling;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> connection = () -> RemoteService.call("connection string");
        Supplier<String> error = () -> RemoteService.call("no connection");
        ExceptionHandler<String> withException = exception -> {
            System.out.println("Ошибка при вызове сервиса");
            return "DEFAULT";
        };

        System.out.println(ErrorHandler.withErrorHandling(connection, withException));
        System.out.println(ErrorHandler.withErrorHandling(error, withException));
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