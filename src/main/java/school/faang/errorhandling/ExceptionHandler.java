package school.faang.errorhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T error(Exception e);
}