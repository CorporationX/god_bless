package school.faang.handle.errors.beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
