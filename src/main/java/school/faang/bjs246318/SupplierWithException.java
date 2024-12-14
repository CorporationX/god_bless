package school.faang.bjs246318;

@FunctionalInterface
public interface SupplierWithException<T> {
    T get() throws Exception;
}
