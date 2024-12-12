package school.faang.task_46199;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}