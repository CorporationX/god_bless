package school.faang.task_46371;

@FunctionalInterface
public interface ExceptionHandler<T>{
    T handle(Exception exception);
}
