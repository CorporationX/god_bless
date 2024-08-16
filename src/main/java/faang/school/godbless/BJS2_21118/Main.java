package faang.school.godbless.BJS2_21118;

import java.util.function.Supplier;

public class Main {

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
