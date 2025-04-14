package school.faang.lambda.error_handler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String resultTwo = ErrorHandler.withErrorHandling(
                RemoteService::call,
                e -> {
                    log.info("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        log.info(resultTwo);
    }
}
