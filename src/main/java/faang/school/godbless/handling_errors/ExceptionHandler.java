package faang.school.godbless.handling_errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
