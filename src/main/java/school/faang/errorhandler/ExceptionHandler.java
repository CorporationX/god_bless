package school.faang.errorhandler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
