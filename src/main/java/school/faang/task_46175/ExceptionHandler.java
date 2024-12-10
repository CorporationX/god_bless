package school.faang.task_46175;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
