package school.faang.errorhandling;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
