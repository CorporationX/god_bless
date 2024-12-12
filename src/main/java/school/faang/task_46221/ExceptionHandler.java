package school.faang.task_46221;

@FunctionalInterface
public interface ExceptionHandler<T> {
    void handle(Exception e);
}
