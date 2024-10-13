package school.faang.errorHandler;

import java.util.function.Function;

public class ErrorHandler {
  public static <T> T withErrorHandling(CheckedSupplier<T> successfulAction, Function<Exception, T> anSuccessfulAction) {
    try {
      return successfulAction.get();
    } catch (Exception e) {
      return anSuccessfulAction.apply(e);
    }
  }
}
