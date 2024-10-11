package school.faang.errorHandler;

@FunctionalInterface
public interface CheckedSupplier<T> {
  T get() throws Exception;
}
