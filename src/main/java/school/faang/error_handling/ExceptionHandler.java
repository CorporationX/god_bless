package school.faang.error_handling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}