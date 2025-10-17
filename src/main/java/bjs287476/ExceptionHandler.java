package bjs287476;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T withErrorHandling(Exception e);
}
