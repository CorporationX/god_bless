package faang.school.godbless.errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T hand(Exception e);
}
