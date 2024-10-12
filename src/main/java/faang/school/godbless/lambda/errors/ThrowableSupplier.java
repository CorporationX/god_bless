package faang.school.godbless.lambda.errors;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    T get() throws Exception;
}
