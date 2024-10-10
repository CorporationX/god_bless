package school.faang.handleerrors;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    T get() throws Exception;
}