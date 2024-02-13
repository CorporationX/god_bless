package faang.school.godbless.lambda.handing_exception;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handler(Exception e);
}
