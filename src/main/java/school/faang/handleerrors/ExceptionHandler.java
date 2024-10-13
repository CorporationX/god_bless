package school.faang.handleerrors;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
