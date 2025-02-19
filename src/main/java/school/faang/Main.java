package school.faang;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> RemoteService.call("some Param"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s\n", e.getMessage());
                    return e.getMessage();
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }

    public static <T> T withErrorHandling(Supplier<T> action, ErrorHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
