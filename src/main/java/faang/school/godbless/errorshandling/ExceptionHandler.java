package faang.school.godbless.errorshandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
