package faang.school.godbless.lambdas.task_9.handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle (Exception e);
}