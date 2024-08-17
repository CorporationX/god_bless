package faang.school.godbless.javalambda.task9;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
