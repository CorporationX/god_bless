package faang.school.godbless.handleErrors;

public interface ExceptionHandler<T> {
    T exception(Exception exceptionHandler);
}
