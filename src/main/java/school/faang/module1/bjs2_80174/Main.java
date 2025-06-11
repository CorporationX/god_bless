package school.faang.module1.bjs2_80174;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        String successResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    log.warn("Ошибка при вызове сервиса: {}. Возвращаем дефолтное значение.", e.getMessage());
                    return "DEFAULT";
                }
        );
        log.info(successResult);

        String failResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("fail"),
                e -> {
                    log.warn("Ошибка при вызове сервиса: {}. Возвращаем дефолтное значение.", e.getMessage());
                    return "DEFAULT";
                }
        );
        log.info(failResult);
    }
}