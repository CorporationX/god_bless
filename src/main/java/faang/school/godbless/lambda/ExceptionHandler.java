package faang.school.godbless.lambda;


@FunctionalInterface
public interface ExceptionHandler<T> {

    T errorHandler(Exception e);
}
