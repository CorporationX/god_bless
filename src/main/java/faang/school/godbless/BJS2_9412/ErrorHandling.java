package faang.school.godbless.BJS2_9412;

import java.util.function.Supplier;

public class ErrorHandling<T> {
  public T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
    T res;
    try {
      res = action.get();
    } catch (Exception e) {
      res = handler.handle(e);
    }
    return res;
  }
}
