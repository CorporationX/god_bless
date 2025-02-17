package errorhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
