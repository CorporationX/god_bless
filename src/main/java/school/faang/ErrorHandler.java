package school.faang;

public interface ErrorHandler<T> {
    T handle(Exception e);
}
