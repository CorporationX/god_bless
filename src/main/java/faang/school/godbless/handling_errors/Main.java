package faang.school.godbless.handling_errors;

import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String param = "Example";
        String result = withErrorHandling(
                () -> new RemoteService().call(param),
                e -> log.warn("Не удалось получить доступ к Remote Service. Значение Default")
        );
        System.out.println("Результат: " + result);
    }

    private static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            exceptionHandler.handleException(e);
            return null;
        }
    }
}
