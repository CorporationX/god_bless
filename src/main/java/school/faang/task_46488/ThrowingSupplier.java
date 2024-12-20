package school.faang.task_46488;

@FunctionalInterface
public interface ThrowingSupplier<T> {

    T get() throws Exception;
}
