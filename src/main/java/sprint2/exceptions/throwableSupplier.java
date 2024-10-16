package sprint2.exceptions;

@FunctionalInterface
public interface throwableSupplier<T> {
    T get() throws Exception;
}
