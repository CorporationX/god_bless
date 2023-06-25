package exception;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
