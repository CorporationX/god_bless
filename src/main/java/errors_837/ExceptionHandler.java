package errors_837;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}