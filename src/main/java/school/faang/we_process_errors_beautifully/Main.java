package school.faang.we_process_errors_beautifully;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    log.info("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        log.info(result);
    }

    public static class RemoteService {
        public static String call(String param) {

            throw new RuntimeException("Сервис недоступен");
        }
    }
}
