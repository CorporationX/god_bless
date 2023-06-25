package faang.school.godbless.lambda.errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
