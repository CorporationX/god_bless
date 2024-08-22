package faang.school.godbless.beautiful.exception.handling;

public interface ThrowingSupplier<T> {
    T get() throws Exception;
}
