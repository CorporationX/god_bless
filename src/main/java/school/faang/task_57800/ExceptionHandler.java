package school.faang.task_57800;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
