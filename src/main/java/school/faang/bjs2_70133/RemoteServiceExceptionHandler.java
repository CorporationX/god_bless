package school.faang.bjs2_70133;

import java.util.function.Supplier;

public class RemoteServiceExceptionHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception ex) {
            return exceptionHandler.catchException(ex);
        }
    }
}
