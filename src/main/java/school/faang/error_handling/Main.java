package school.faang.error_handling;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                e -> {  // Обработка ошибки
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Выведет результат: "DEFAULT" при ошибке
    }

    // Пример метода для удалённого сервиса
    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}
