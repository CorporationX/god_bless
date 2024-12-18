package faang.school.godbless.sprint_2.task_46273;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
