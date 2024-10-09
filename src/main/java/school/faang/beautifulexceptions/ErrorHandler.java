package school.faang.beautifulexceptions;


public class ErrorHandler {
    public static <T, E extends Exception> T withErrorHandling(ThrowableFunction<T, E> function, ExceptionHandler<T> errorHandler) {
        try {
            return function.apply();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
