package faang.school.godbless.BJS2_21227;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handling(Exception e);
}
