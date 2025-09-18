package bjs2_91603;

public class Main {
    public static void main(String[] args) {

        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Какой-то там параметр"),
                e -> {  // Эксепшн
                    System.out.println("Ошибка при вызове сервиса: " + e.getMessage());
                    return "Дефолт";
                }
        );

        System.out.println("Результ: " + result);
    }

    // удалённый какой-то там сервис
    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен"); // кидаем ошибку
        }
    }
}