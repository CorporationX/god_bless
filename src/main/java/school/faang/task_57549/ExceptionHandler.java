package school.faang.task_57549;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
