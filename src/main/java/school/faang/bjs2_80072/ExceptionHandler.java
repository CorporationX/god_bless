package school.faang.bjs2_80072;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
