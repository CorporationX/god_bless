package faang.school.godbless;

import java.util.function.Supplier;

public class ErrorHandling<T> {

    public T withErrorHandling(Supplier<T> supplier, ExceptionHandler exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            exceptionHandler.handle(e);
            return null;
        }
    }
}
