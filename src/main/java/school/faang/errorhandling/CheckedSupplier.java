package school.faang.errorhandling;

@FunctionalInterface
public interface CheckedSupplier<T> {
    T get() throws Exception;
}
