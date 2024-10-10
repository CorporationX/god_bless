package school.faang.coolerrorhandling;

public interface ExceptionHandler<T> {
    T execute() throws Exception;
}
