package faang.school.godbless.sprint1.errorHandler;

import java.util.function.Supplier;

/**
 * @author Evgenii Malkov
 */
public class ServiceCallHelper {
  static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> failure) {
    try {
      return action.get();
    } catch (Exception e) {
      return failure.onError(e);
    }
  }
}
