package school.faang.Errors;

@FunctionalInterface
public interface ErrorSupplier<T>{
    T get() throws Exception;
}
