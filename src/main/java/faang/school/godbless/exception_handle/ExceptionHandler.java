package faang.school.godbless.exception_handle;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
