package school.faang;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
