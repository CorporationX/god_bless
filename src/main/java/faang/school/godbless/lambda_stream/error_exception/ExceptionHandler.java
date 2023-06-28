package faang.school.godbless.lambda_stream.error_exception;

interface ExceptionHandler<T> {
    T handle(Exception ex);
}