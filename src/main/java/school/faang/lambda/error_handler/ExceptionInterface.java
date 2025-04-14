package school.faang.lambda.error_handler;

@FunctionalInterface
public interface ExceptionInterface<T> {
    T handle(Exception e);
}
