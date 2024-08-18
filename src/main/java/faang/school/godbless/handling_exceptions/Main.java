package faang.school.godbless.handling_exceptions;

import java.util.function.Supplier;

public class Main {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception exception) {
            return onError.handle(exception);
        }
    }
}
