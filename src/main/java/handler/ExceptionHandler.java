package handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
