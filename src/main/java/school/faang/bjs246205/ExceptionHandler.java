package school.faang.bjs246205;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T apply(Exception e);
}