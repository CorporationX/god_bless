package faang.school.godbless.errorHandling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
