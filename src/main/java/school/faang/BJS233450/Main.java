package school.faang.BJS233450;

import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }

    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = withErrorHandling(
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
            // Здесь возникнет ошибка для демонстрации
            throw new Exception("Сервис недоступен");
        }
    }
}
