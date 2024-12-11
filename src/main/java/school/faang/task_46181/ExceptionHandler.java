package school.faang.task_46181;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T handle(Exception exception);
}
