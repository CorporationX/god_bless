package faang.school.godbless.BJS2_5371;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
