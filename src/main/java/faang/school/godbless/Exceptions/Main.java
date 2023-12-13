package faang.school.godbless.Exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String... args) {

        var result = withErrorHandling(() -> 5 / 0, (exception) -> {
            System.err.println("Ошибка: " + exception.getMessage());
            return 0;
        });
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return exceptionHandler.handler(exception);
        }
    }
}
