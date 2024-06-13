package faang.school.godbless.error_prettifier;

import java.util.function.Supplier;

public class PrettyError{
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler exceptionHandler) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            exceptionHandler.handle(e);
        }
//        idk how it can be handled in parametrized function without null
        return null;
    }
}
