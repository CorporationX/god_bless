package school.faang.errorhandling.main;

@FunctionalInterface
public interface ErrorHandler<T> {
    T handler(Exception e);
}
