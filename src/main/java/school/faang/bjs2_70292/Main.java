package school.faang.bjs2_70292;

import java.util.function.Function;

/**
 * Задача "Обрабатываем ошибки красиво"
 */
public class Main {
    public static void main(String[] args) {

        Function<Exception, String> exceptionHandler = e -> {  // Обработка ошибки
            System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        };

        // Пример с вызовом удалённого сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),  // Основное действие
                exceptionHandler
        );
        System.out.println(result);

        String error = ErrorHandler.withErrorHandling(
                () -> RemoteService.call(""),  // Основное действие
                exceptionHandler
        );
        System.out.println(error);  // Выведет результат: "DEFAULT" при ошибке
    }

    public static class RemoteService {
        private RemoteService() {
        }

        public static String call(String param) {
            if (param == null || param.isEmpty()) {
                throw new RuntimeException("Сервис недоступен");
            }
            return param;
        }
    }
}
