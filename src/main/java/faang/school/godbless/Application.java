package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Application {
    public static void main(String... args) {
        List<Integer> list = List.of(3);

        Supplier<Integer> supplier = () -> list.get(1); // иммитация exception
        ExceptionHandler<Integer> exceptionHandler = exception -> list.get(0);

        ExceptionHandler.withErrorHandling(supplier, exceptionHandler);
    }
}
