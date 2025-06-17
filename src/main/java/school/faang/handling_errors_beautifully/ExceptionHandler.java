package school.faang.handling_errors_beautifully;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
