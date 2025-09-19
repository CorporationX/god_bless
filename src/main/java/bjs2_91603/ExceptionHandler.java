package bjs2_91603;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}