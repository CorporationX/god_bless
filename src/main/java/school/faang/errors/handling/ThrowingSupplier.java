package school.faang.errors.handling;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
