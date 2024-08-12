package faang.school.godbless.BJS221095;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
