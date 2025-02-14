package school.faang.handlingerrorsbeautifully;

public interface ExceptionHandler<T> {
    T handle(Exception e);
}
