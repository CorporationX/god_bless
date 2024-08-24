package faang.school.godbless.handling_exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception exception);
}
