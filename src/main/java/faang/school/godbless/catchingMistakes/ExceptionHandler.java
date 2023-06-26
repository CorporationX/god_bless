package faang.school.godbless.catchingMistakes;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
