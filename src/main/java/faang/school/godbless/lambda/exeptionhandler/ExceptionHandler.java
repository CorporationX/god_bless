package faang.school.godbless.lambda.exeptionhandler;


@FunctionalInterface
public interface ExceptionHandler<T> {

    T errorHandler(Exception e);
}
