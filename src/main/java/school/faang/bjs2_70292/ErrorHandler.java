package school.faang.bjs2_70292;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    private ErrorHandler() {
    }

    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
