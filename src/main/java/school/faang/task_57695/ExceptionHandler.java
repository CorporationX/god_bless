package school.faang.task_57695;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
