package school.faang.sprint2.task_57549;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
