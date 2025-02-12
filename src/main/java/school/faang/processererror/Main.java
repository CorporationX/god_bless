package school.faang.processererror;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = Main.withErrorHandling(
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
        public static String call(String param) {
            // Здесь возникнет ошибка для демонстрации
            throw new RuntimeException("Сервис недоступен");
        }
    }

    public static <T> T withErrorHandling(RunServer<T> runServer, Function<Exception, T> errorHandling) {
        try {
            return runServer.run();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }
}
