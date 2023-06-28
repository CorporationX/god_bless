package LambdaStream.bc1311;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
