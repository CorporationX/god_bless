package school.faang.error;

@FunctionalInterface
public interface Caller<T> {
    T call();
}
