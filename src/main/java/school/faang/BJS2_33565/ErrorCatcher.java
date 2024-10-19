package school.faang.BJS2_33565;

@FunctionalInterface
public interface ErrorCatcher<T> {
    public T catchError(Exception e);
}
