package school.faang.bjs2_70122;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T raise(Exception e);
}
