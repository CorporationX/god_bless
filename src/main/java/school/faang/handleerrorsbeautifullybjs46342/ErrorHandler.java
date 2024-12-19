package school.faang.handleerrorsbeautifullybjs46342;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> errorHandling) {
        if (action == null || errorHandling == null) {
            throw new IllegalArgumentException("Action and errorHandling cannot be null");
        }
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }
}
