package bjs2_33389;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
