package school.faang.bjs246318;

public class ErrorHandler {
    public static <T> T withErrorHandling(SupplierWithException<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
