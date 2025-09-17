package school.faang.errorhandling_bjs2_91605;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandling.handler(e);
        }
    }
}
