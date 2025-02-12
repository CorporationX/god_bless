package school.faang.bjs2_57504;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
