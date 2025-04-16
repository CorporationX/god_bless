package school.faang.handlingerrors;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
