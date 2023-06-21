package faang.school.godbless.errors;

public interface ExceptionHandler<T> {
  T handle(Exception e);
}
