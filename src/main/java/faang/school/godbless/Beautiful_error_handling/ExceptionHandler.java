package faang.school.godbless.Beautiful_error_handling;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
