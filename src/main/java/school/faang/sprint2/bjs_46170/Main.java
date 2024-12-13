package school.faang.sprint2.bjs_46170;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String resultWithError = ErrorHandler.withErrorHandling(
                () -> RemoteService.exceptionCall("do something"),
                e -> {
                    log.warn("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        log.info(resultWithError);

        String successfulResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("All is good"),
                e -> "DEFAULT"
        );
        log.info(successfulResult);
    }
}

