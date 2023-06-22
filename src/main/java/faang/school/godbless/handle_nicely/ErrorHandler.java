package faang.school.godbless.handle_nicely;

import java.util.function.Supplier;

public class ErrorHandler {
    static <T> T withErrorHandling(Supplier<T> processor, ExceptionHandler<T> exceptionHandler) {
        try {
            return processor.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
