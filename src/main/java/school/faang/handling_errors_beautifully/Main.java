package school.faang.handling_errors_beautifully;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }

    public static class ErrorHandler {
        public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
            try {
                return action.get();
            } catch (Exception e) {
                return errorHandler.handle(e);
            }
        }
    }
}