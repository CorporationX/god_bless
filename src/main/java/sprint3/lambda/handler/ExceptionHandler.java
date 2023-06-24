package sprint3.lambda.handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
