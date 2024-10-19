package school.faang.spring2.exeptions;

@FunctionalInterface
public interface throwableSupplier<T> {
    T get() throws Exception;
}
