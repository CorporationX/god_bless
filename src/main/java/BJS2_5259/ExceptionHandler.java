package BJS2_5259;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
