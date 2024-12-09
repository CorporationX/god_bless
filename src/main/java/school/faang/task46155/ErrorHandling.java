package school.faang.task46155;

@FunctionalInterface
public interface ErrorHandling<T> {
    T handleError(Exception e);
}