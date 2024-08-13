package faang.school.godbless.task.lambda.handling.exceptions.beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
