package faang.school.godbless.secondsprint.exceptionhandling;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class ErrorHandlingUtil {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            log.warn("При вызове удалённого сервиса произошла ошибка", e);
            return errorHandler.handle(e);
        }
    }

    public static void main(String[] args) {
        String result = ErrorHandlingUtil.withErrorHandling(
                () -> mockRemoteServiceCall("param"),
                (e) -> {
                    log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return "DEFAULT";
                }
        );

        System.out.println("Результат: " + result);
    }

    private static String mockRemoteServiceCall(String param) {
        if ("param".equals(param)) {
            throw new RuntimeException("Ошибка удалённого сервиса");
        }
        return "УСПЕШНО";
    }
}
