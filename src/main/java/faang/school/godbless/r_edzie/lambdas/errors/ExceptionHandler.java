package faang.school.godbless.r_edzie.lambdas.errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
