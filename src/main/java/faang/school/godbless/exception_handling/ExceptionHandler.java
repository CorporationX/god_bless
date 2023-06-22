package faang.school.godbless.exception_handling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
