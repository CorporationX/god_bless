package faang.school.godbless.exception;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
