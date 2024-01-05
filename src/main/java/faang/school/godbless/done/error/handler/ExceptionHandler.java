package faang.school.godbless.done.error.handler;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T log(Exception e);
}
