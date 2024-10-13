package school.faang;

@FunctionalInterface
public interface ThrowingSupplier<T>{
    T get() throws Exception;
}
