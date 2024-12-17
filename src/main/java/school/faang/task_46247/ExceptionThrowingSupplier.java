package school.faang.task_46247;

public interface ExceptionThrowingSupplier<T> {
    T get() throws Exception;
}
