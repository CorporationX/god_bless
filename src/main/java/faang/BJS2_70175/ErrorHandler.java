package faang.BJS2_70175;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandler(Supplier<T> main, Function<Throwable, T> errorHandler) {
        try {
            return main.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}

