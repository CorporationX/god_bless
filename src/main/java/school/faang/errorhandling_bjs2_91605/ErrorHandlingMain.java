package school.faang.errorhandling_bjs2_91605;

public class ErrorHandlingMain {
    public static void main(String[] args) {
        String result = ErrorHandling.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {

            throw new RuntimeException("Сервис недоступен");
        }
    }
}
