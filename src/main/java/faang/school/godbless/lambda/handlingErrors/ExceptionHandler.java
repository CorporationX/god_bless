package faang.school.godbless.lambda.handlingErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
