package school.faang.hashMapStreamApiFunctionalInterface.handleExceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
