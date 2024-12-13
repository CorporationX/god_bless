package school.faang.task_46239;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
