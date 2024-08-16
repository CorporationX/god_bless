package faang.school.godbless.bjs2_21109;

import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
