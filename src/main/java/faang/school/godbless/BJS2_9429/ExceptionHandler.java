package faang.school.godbless.BJS2_9429;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
