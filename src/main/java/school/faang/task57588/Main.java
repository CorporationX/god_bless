package school.faang.task57588;

import school.faang.task57588.service.ErrorHandler;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса: " + e.getMessage());
                    return "DEFAULT";
                }
        );

        System.out.println("Результат: " + result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}