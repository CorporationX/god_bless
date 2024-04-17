package faang.school.godbless.beautyexception;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception exception);
}
