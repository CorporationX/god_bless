package faang.school.godbless.handleErrorsGracefuly;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T doIfException(Exception e);
}
