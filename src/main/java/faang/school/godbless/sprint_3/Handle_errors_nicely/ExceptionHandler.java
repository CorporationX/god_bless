package faang.school.godbless.sprint_3.Handle_errors_nicely;
@FunctionalInterface
public interface ExceptionHandler<S,E> {
    S apply(E exception);
}
