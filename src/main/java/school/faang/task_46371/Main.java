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
        String result = withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws RuntimeException {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
