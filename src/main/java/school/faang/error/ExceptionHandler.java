package school.faang.error;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
