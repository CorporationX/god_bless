package faang.school.godbless.ErrorHandling;

@FunctionalInterface
public interface ExceptionHandler<E extends Exception> {
    void handle(E exception);

}
