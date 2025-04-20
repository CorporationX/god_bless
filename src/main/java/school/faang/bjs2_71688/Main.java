package school.faang.bjs2_71688;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ErrorHandler.withErrorHandling(
            () -> RemoteService.call("someParam"),
            e -> {
                log.warn("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                return "DEFAULT";
            }
        );

        ErrorHandler.withErrorHandling(
            () -> RemoteService.call("someGoodParam"),
            e -> {
                log.warn("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                return "DEFAULT";
            }
        );
    }

    public static class RemoteService {
        public static String call(String param) {
            if (param.equals("someParam")) {
                throw new RuntimeException("Сервис недоступен");
            } else {
                log.info("Все сработало номрмально");
                return "OK";
            }
        }
    }
}
