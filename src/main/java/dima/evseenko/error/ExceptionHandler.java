package dima.evseenko.error;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
