package faang.school.godbless.BJS2_21123;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
