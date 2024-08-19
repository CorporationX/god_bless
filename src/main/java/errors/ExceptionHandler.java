package errors;

@FunctionalInterface
public interface ExceptionHandler {
    public Exception operation(Exception exception);
}
