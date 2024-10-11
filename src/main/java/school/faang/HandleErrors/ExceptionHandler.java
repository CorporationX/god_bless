package school.faang.HandleErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}