package school.faang.BJS2_33441_HandlingErrorsBeautifully;

@FunctionalInterface
public interface ThrowableAction<T> {
    T get() throws Exception;
}
