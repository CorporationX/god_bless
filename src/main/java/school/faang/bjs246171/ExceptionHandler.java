package school.faang.bjs246171;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}