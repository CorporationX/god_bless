package faang.school.godbless.sprint2.Handle_errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T exception(Exception handleException);
}
