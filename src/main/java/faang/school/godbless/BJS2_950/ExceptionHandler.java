package faang.school.godbless.BJS2_950;
@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
