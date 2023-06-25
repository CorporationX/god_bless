package faang.school.godbless;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
