package faang.school.godbless.sprint2.exceptionHandling;

public interface CheckedExceptionSupplier<T> {

    T get() throws Exception;
}
