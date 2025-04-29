package processing.exceptions;

@FunctionalInterface
public interface ServiceCallable<T> {
    T returnDefault(Exception e);
}
