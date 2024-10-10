package school.faang.handleerrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception E);
}