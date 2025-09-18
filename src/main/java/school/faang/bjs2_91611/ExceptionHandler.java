package school.faang.bjs2_91611;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
