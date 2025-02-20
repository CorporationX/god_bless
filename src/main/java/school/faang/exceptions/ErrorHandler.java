package school.faang.exceptions;

public interface ErrorHandler<T> {
    T handle(Exception e);
}
