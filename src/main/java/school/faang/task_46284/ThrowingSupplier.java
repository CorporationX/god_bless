package school.faang.task_46284;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
