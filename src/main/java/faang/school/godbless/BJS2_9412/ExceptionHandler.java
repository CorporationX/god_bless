package faang.school.godbless.BJS2_9412;

@FunctionalInterface
public interface ExceptionHandler<T> {
  T handle(Exception ex);
}
