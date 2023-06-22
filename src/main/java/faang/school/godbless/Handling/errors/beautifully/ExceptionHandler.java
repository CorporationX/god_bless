package faang.school.godbless.Handling.errors.beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T doCatch(Exception exception);
}
