package school.faang.jbs2_33512.functional;


public interface CheckedSupplier<T> {
    T run() throws Exception;
}
