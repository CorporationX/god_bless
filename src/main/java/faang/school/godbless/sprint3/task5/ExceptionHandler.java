package faang.school.godbless.sprint3.task5;

@FunctionalInterface
public interface ExceptionHandler<T> {

    T exceptionHandler(Exception e);
}
