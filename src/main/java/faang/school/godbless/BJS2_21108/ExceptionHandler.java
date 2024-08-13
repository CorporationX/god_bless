package faang.school.godbless.BJS2_21108;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
