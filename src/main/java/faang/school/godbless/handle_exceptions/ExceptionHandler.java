package faang.school.godbless.handle_exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}