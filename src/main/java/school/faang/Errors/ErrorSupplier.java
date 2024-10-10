package school.faang.Errors;

import java.util.function.Supplier;

@FunctionalInterface
public interface ErrorSupplier<T>{
    T get() throws Exception;
}
