package faang.school.godbless.errors;

import java.util.function.Supplier;

public class ErrorHandler {
  public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
    try {
      return action.get();
    } catch (Exception e) {
      return exceptionHandler.handle(e);
    }
  }
}
