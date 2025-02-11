package school.faang.errorhandler;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> successAction, Function<Exception, T> exceptionAction) {
        try {
            return successAction.get();
        } catch (Exception e) {
            return exceptionAction.apply(e);
        }
    }
}
