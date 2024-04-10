package faang.school.godbless.BJS2_5165;

@FunctionalInterface
public interface ExceptionHandler<T> {
  T handle(Exception ex);
}
