package faang.school.godbless.ProcessErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
