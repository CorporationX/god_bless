package faang.school.godbless.BJS2_21119;

import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> onError) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
