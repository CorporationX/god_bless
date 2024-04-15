package faang.school.godbless.sprint_2.handle_exceptions;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}