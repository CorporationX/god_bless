package school.faang.task216.errorhandler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T getDefault(Exception e);
}
