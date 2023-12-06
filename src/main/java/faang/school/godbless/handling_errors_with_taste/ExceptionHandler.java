package faang.school.godbless.handling_errors_with_taste;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}