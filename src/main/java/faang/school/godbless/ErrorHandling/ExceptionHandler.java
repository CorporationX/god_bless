package faang.school.godbless.ErrorHandling;

@FunctionalInterface
public interface ExceptionHandler<T extends Exception> {
    T handle(T exception);

}
