package faang.school.godbless.BJS2_9524;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
