package faang.school.godbless.BJS2_21116;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handling) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return handling.computeException(exception);
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hi", "hello", "lol");
        String string = withErrorHandling(() -> strings.get(0), (exception) -> {
            System.out.println(exception.getMessage());
            return "ERROR";
        });
        System.out.println(string);
    }
}
