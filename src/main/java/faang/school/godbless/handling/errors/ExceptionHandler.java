package faang.school.godbless.handling.errors;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
