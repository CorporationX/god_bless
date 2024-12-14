package faang.school.godbless.errorHandling;

import java.util.function.Supplier;

public class ErrorHandling<T> {

    public T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
