package Handle_Errors_Beautifully;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
