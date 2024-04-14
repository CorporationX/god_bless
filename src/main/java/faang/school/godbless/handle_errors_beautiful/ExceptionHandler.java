package faang.school.godbless.handle_errors_beautiful;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception exception);
}
