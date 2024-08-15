package faang.school.godbless.metaExceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleError(Exception e);
}
