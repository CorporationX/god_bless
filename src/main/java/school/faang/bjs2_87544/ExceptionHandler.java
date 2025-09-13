package school.faang.bjs2_87544;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
