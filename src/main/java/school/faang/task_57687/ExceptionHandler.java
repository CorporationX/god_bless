package school.faang.task_57687;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T processing(Exception exception);
}
