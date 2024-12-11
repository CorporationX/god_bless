package school.faang.task_46187;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
