package school.faang.bjs2_87565;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
