package faang.school.godbless.lambda.BJS2_5812;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
