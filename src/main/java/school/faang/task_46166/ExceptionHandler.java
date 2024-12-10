package school.faang.task_46166;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
