package school.faang.sprint.second.exception;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static String withErrorHandling(Supplier<String> action, Function<Exception, String> s) {
        try {
            return action.get();
        } catch (Exception e) {
            return s.apply(e);
        }
    }
}
