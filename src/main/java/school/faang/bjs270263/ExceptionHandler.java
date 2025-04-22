package school.faang.bjs270263;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception e);
}
