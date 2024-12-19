package school.faang.spint2.task46302error;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);
}
