package school.faang.bjs2_80192;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ErrorFunction<T> errorFunction) {
        T result;
        try {
            result = supplier.get();
        } catch (Exception e) {
            result = errorFunction.action(e);
        }
        return result;
    }
}
