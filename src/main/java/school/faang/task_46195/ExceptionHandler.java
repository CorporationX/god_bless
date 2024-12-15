package school.faang.task_46195;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}