package school.faang.task_46371;

import ch.qos.logback.core.net.SocketConnector;

import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> normalAction, ExceptionHandler<T> exceptionAction) {
        try {
            return normalAction.get();
        } catch (Exception exception) {
            return exceptionAction.handle(exception);
        }
    }

    public static void main(String[] args) {
        // Пример с вызовом удалённого сервиса
        String result = withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },  // Основное действие
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
