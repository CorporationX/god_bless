package school.faang.bjs246514;

public interface ExceptionSupplier<T> {

    T handle(Exception e);

}
