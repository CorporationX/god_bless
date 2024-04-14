package faang.school.godbless.bjs2_5025;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Supplier;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Supplier<String> task = () -> {
            System.out.println("Executing service");
            return "OK";
        };
        handleTaskWithError(task, exception -> "DEFAULT");
    }

    public static <T> T handleTaskWithError(Supplier<T> function, ExceptionHandler<T> exception) {
        try {
            return function.get();
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return exception.handle(e);
        }
    }
}
