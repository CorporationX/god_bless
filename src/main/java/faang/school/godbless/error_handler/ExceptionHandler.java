package faang.school.godbless.error_handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
