package faang.school.godbless.handlingerrors;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}