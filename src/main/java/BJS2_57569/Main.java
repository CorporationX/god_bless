package BJS2_57569;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String SOME_PARAM = "someParam";

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call(SOME_PARAM),
                e -> {
                    log.info("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        log.info(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            log.error(param);
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
