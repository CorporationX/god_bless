package faang.school.godbless.handle_nicely;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
