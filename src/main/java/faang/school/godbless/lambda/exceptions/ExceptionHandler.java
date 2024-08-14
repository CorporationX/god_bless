package faang.school.godbless.lambda.exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Throwable throwable);
}
