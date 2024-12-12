package derschrank.sprint02.task06.bjstwo_46575;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> mainAction, Function<Exception, T> errorHandler) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
