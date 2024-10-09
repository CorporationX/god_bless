package school.faang.beautifulexceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
