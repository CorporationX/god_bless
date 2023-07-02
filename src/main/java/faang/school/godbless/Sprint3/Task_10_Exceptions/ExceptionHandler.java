package faang.school.godbless.Sprint3.Task_10_Exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
