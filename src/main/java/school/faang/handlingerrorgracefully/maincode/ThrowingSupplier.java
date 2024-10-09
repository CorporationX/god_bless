package school.faang.handlingerrorgracefully.maincode;

@FunctionalInterface
public interface ThrowingSupplier<T> {
    T get() throws Exception;
}


