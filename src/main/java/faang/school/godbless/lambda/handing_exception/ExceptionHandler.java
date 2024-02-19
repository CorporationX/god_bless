package faang.school.godbless.lambda.handing_exception;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
