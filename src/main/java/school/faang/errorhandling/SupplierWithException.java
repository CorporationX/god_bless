package school.faang.errorhandling;

@FunctionalInterface
public interface SupplierWithException<T> {
    T get() throws Exception;
}
