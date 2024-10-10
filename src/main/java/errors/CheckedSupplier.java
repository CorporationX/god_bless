package errors;

public interface CheckedSupplier<T> {
    T get() throws Exception;
}