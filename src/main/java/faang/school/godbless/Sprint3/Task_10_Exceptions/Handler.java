package faang.school.godbless.Sprint3.Task_10_Exceptions;

import java.util.function.Supplier;

public class Handler {
    static <T> T withErrorHandling (Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
