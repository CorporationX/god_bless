package school.faang.handle_exceptions_gracefully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}