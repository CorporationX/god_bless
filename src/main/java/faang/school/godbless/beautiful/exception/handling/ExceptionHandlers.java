package faang.school.godbless.beautiful.exception.handling;

@FunctionalInterface
public interface ExceptionHandlers<T> {
    T handle(Exception e);
}
