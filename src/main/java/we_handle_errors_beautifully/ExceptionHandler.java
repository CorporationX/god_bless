package we_handle_errors_beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
