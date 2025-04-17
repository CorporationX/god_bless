package school.faang.handler;

@FunctionalInterface
public interface ExceptionHandling<T> {

    T handler(Exception exception);
}
