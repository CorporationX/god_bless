package faang.school.godbless.errorHandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
