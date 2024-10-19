package school.faang.sprint2.exeptions;

@FunctionalInterface
public interface throwableSupplier<T> {
    T get() throws Exception;
}
