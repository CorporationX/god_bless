package school.faang.bjs246318;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
