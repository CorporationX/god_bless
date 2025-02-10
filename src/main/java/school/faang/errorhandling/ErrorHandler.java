package school.faang.errorhandling;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> callingService, ExceptionHandler<T> errorHandling) {
        try {
            return callingService.get();
        } catch (Exception e) {
            return errorHandling.handle(e);
        }
    }
}
