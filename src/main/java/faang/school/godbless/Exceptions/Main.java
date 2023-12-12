package faang.school.godbless.Exceptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String... args) {

        Exception exception = withErrorHandling(() -> {
            return 5 / 0;
        }, (pod) -> {
            return pod;
        });
        System.out.println(exception);
    }

    public static Exception withErrorHandling(Supplier<Integer> supplier, ExceptionHandler<Exception> exceptionHandler) {
        Exception ds = null;
        try {
            System.out.println(supplier.get());
        } catch (Exception r) {
            ds = exceptionHandler.handler(r);
        }
        return ds;
    }
}
