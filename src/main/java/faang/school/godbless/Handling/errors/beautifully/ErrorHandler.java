package faang.school.godbless.Handling.errors.beautifully;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler<T> {

    static public <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.doCatch(e);
        }
    }
}
