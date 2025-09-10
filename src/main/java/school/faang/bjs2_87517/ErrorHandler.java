package school.faang.bjs2_87517;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supp, Function<Exception, T> errorHandler) {
        try {
            return supp.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
