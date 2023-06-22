package faang.school.godbless.sprint_3.handling_errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T accept(Exception exception);
}
