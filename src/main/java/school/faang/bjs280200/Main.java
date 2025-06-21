package school.faang.bjs280200;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    log.error("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        log.info(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            if ("success".equals(param)) {
                return "SUCCESS_RESPONSE";
            }
            throw new RuntimeException("Сервис недоступен");
        }
    }
}