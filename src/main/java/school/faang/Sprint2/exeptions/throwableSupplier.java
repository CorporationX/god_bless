package school.faang.Sprint2.exeptions;

@FunctionalInterface
public interface throwableSupplier<T> {
    T get() throws Exception;
}
