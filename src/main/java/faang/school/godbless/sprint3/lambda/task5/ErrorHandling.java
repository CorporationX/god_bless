package faang.school.godbless.sprint3.lambda.task5;

import java.util.function.Supplier;

public class ErrorHandling<T> {

    public T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.exceptionHandler(e);
        }
    }
}
