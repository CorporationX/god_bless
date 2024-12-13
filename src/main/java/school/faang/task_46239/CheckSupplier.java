package school.faang.task_46239;

@FunctionalInterface
public interface CheckSupplier<T> {
    T get() throws Exception;
}
