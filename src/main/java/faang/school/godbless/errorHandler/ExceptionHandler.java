package faang.school.godbless.errorHandler;

/**
 * @author Evgenii Malkov
 */
public interface ExceptionHandler<T> {
  T onError(Exception exception);
}
