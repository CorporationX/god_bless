package school.faang.functionalInterface.handlingErrors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handler(Exception e);
}
