package school.faang.handlingerrors;

public interface ExceptionHandler<T> {
    T handle(Throwable e);
}
