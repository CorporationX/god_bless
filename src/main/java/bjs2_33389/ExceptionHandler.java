package bjs2_33389;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
