package school.faang.spring2.task_46211;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    T get() throws Exception;
}
