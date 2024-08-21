package faang.school.godbless.secondsprint.exceptionhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
