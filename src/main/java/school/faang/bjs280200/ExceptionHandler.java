package school.faang.bjs280200;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}