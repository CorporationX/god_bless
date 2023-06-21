package faang.school.godbless.ErrorProcessing;

import java.util.function.Supplier;

public class ExceptionUtil {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        T res;
        try {
            res = supplier.get();
        } catch (Exception e) {
            res = exceptionHandler.handle(e);
        }
        return res;
    }
}
