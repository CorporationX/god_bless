package school.faang.beautifulexception;

@FunctionalInterface
public interface InterfaceException<T> {
    T get() throws Exception;
}
