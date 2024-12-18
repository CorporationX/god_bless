package error;

@FunctionalInterface
public interface ErrorHandling<T> {
    T handleError(Exception e);
}
