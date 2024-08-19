package faang.school.godbless.metaExceptions;

import java.util.function.Supplier;

public class HandlerService<T> {
    public T withErrorHandling(Supplier<T> requestHandler, ExceptionHandler<T> exceptionHandler) {
        T response;
        try {
            response = requestHandler.get();
        } catch (Exception e) {
            response = exceptionHandler.handleError(e);
        }
        return response;
    }
}
