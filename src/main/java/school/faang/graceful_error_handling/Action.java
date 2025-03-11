package school.faang.graceful_error_handling;

@FunctionalInterface
interface Action<T> {
    T act() throws Exception;
}
