package school.faang.BJS2_33441_HandlingErrorsBeautifully;

@FunctionalInterface
public interface ThrowableAction<T, E extends Exception> {
    T get() throws E;
}
