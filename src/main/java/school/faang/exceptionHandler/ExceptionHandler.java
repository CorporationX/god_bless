package school.faang.exceptionHandler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
