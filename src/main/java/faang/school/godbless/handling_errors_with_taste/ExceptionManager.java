package faang.school.godbless.handling_errors_with_taste;

import java.util.function.Supplier;

public class ExceptionManager {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
