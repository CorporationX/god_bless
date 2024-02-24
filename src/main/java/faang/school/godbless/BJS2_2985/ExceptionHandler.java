package faang.school.godbless.BJS2_2985;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
