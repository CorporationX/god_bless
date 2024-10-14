package school.faang.handleExceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
