package errors.handling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
