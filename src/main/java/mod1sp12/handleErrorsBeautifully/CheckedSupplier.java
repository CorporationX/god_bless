package mod1sp12.handleErrorsBeautifully;

@FunctionalInterface
public interface CheckedSupplier <T> {
    T get() throws Exception;
}
