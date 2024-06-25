package faang.school.godbless.sprint1.errorHandler;

/**
 * @author Evgenii Malkov
 */
public interface ExceptionHandler<T> {
  T onError(Exception exception);
}
