package school.faang.sprint_2.task_43530;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
