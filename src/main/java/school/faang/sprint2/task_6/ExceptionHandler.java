package school.faang.sprint2.task_6;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
