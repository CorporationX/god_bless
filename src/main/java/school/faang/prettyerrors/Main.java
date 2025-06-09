package school.faang.prettyerrors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
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
        log.info(result);  // Выведет результат: "DEFAULT" при ошибке
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class RemoteService {
        public static String call(String param) {
            throw new ServiceUnavailable();
        }
    }
}
