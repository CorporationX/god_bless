package faang.school.godbless.BJS2_9485;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
