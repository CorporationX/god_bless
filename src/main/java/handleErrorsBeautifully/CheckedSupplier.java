package handleErrorsBeautifully;

@FunctionalInterface
public interface CheckedSupplier <T> {
    T get() throws Exception;
}
