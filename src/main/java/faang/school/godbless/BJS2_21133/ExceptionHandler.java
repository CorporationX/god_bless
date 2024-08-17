package faang.school.godbless.BJS2_21133;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
