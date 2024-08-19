package faang.school.godbless.ErrorHandling;

@FunctionalInterface
public interface ExceptionHandler<V> {
    V handle(V defaultValue, Exception exception);

}
