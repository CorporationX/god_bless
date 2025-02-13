package BJS257630;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
