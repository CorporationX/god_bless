package faang.school.godbless.javalambda.task9;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "PARAM";
        Supplier<String> stringSupplier2 = () -> {
            throw new IllegalStateException();
        };
        ExceptionHandler<String> exceptionHandler = e -> {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };
        System.out.println(withErrorHandling(stringSupplier, exceptionHandler));
        System.out.println(withErrorHandling(stringSupplier2, exceptionHandler));
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
