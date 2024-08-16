package faang.school.godbless.BJS2_21118;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T apply(Exception e);
}
