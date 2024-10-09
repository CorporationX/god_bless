package school.faang.process.exception.beautiful;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
