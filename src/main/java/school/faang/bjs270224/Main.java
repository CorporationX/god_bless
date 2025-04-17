package school.faang.bjs270224;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("hello"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s", e.getMessage());
                    return "DEFAULT";
                }
        );
        System.out.printf("Результат: %s%n", result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен ");
        }
    }
}
