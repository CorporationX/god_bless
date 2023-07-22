package faang.school.godbless.calculator.handle_errors_beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleError(Exception e);
}
