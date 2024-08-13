package faang.school.godbless.BJS2_21107;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}