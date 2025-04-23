package school.faang.bjs2_71710;

@FunctionalInterface
public interface ExceptionSupplier<T> {
    T get() throws Exception;
}
