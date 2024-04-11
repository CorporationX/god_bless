package faang.school.godbless.greatexception;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
