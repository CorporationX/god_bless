package faang.school.godbless.handleErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception ex);
}
