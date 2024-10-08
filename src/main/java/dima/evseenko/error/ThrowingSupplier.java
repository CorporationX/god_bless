package dima.evseenko.error;

@FunctionalInterface
public interface ThrowingSupplier<R> {
    R get() throws Exception;
}
