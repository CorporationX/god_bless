package school.faang.task_46159;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
