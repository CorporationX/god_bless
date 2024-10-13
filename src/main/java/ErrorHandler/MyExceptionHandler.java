package ErrorHandler;

public interface MyExceptionHandler<T> {
    T handleException(Exception e);
}
