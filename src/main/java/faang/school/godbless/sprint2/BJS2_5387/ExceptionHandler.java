package faang.school.godbless.sprint2.BJS2_5387;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}