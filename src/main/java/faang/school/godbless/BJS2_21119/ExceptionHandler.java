package faang.school.godbless.BJS2_21119;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
