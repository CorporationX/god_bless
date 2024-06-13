package faang.school.godbless.lambdas.errorhandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
