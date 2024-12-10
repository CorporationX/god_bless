package school.faang.task_46222;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
