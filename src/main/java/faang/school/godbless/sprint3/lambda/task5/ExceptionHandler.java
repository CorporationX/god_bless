package faang.school.godbless.sprint3.lambda.task5;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T exceptionHandler(Exception e);
}
