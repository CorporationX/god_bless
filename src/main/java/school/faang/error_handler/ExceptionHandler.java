package school.faang.error_handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    void handle(Exception e);
}
