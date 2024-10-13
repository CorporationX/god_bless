package school.faang;

@FunctionalInterface
public interface ExeptionHandler<T> {
    T handle(Exception e);
}
