package errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
