package school.faang.beautifulexceptions;

@FunctionalInterface
public interface ThrowableFunction<T, E extends Exception> {
    T apply() throws E;
}
