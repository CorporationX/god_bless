package school.faang.sprint_2.bjs2_33455;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> action, Function<Exception, T> handler) {
        try {
            return action.call();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
