package school.faang.bjs246514;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception e);

}
