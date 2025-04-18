package school.faang.sprint_2.processing_exceptions;

@FunctionalInterface
public interface ErrorFallback<T> {
    T returnDefault(Exception e);
}
