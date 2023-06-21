package handle_exception_beautifully;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
