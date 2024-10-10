package school.faang.BJS2_33441_HandlingErrorsBeautifully;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowableAction<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
