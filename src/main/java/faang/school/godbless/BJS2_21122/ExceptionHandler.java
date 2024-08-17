package faang.school.godbless.BJS2_21122;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
