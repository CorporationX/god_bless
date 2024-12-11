package school.faang.task_46181;

@FunctionalInterface
public interface ThrowingExceptionSupplier<T> {

    T get() throws Exception;
}
