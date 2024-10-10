package school.faang.error;

public class ErrorHandler {

  public static <T, E extends Exception> T withErrorHandling(ThrowableSupplier<T, E> action,
      ExceptionHandler<T> exceptionHandler) {
    try {
      return action.get();
    } catch (Exception e) {
      return exceptionHandler.handle(e);
    }
  }
}