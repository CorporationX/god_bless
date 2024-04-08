package faang.school.godbless.bjs2_5025;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Callable<String> task = () -> {
            System.out.println("Executing service");
            return "OK";
        };
        withErrorHandling(task, exception -> "DEFAULT");
    }

    public static <T> T withErrorHandling(Callable<T> function, ExceptionHandler<T> exception) {
        try {
            return function.call();
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return exception.handle(e);
        }
    }
}
