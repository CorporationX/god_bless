package school.faang.sprint_2.task_46292;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
