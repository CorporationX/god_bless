package school.faang.task_46199;

@FunctionalInterface
interface CheckedSupplier<T> {
    T get() throws Exception;
}