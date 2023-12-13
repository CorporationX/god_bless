package faang.school.godbless.Exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String... args) {

        var result = withErrorHandling(() -> {
            return 5 / 2;
        }, (pod) -> {
            return pod;
        });
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        T result;
        try {
            result = supplier.get();
        } catch (Exception r) {
            result = exceptionHandler.handler(r);
        }
        return result;
    }
}
