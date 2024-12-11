package school.faang.bjs246171;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Exception;
}
