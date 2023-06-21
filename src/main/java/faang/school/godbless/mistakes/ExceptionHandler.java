package faang.school.godbless.mistakes;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handWithException(T param);
}
