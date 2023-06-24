package faang.school.godbless.we_handle_errors_beautifully;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T getServiceException(Exception e);
}
