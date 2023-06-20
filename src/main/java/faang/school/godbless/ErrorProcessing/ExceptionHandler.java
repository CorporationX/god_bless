package faang.school.godbless.ErrorProcessing;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
