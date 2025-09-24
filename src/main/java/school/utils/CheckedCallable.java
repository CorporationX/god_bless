package school.utils;

public interface CheckedCallable<T> {
    T call() throws Exception;
}
