package faang.school.godbless.BJS2_21200;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handlingException(Exception exception);
}
