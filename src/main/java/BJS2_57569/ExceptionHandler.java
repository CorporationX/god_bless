package BJS2_57569;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
