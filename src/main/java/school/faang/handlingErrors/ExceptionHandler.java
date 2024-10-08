package school.faang.handlingErrors;

@FunctionalInterface
public interface ExceptionHandler<T, R, E extends Exception> {
    R apply(T t) throws E;
}
