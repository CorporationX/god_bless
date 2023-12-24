package faang.school.godbless.error.handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T log(Exception e);
}
