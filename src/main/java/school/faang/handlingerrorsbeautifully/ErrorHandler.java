package school.faang.handlingerrorsbeautifully;

import java.util.function.Supplier;

public class ErrorHandler<T> {
    public static <T> T withErrorHandling(Supplier<T> action,
                                          ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}