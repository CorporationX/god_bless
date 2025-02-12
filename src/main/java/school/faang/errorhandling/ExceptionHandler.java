package school.faang.errorhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
