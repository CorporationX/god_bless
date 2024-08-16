package faang.school.godbless.ErrorHandling;

@FunctionalInterface
public interface ExceptionHandler<E extends Exception,V> {
    V handle(E exception,V defaultValue);

}
