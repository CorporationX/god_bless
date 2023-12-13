package faang.school.godbless.Exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handler(Exception exception);
}
