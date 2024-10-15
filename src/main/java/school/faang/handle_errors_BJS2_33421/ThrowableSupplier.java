package school.faang.handle_errors_BJS2_33421;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    T get() throws Exception;
}
