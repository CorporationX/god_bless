package school.faang.task_46221;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
