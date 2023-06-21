package faang.school.godbless.error_exception;

interface ExceptionHandler<T> {
    T handle(Exception ex);
}