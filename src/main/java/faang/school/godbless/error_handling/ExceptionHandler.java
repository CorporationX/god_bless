package faang.school.godbless.error_handling;

public interface ExceptionHandler<T> {
    T handleException(Exception e);
}
