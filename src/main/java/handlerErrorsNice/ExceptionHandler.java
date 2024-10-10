package handlerErrorsNice;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T get() throws Exception;
}
