package school.faang.bjs246297;

@FunctionalInterface
public interface ExceptionalHandler<T> {
    T handle(Exception e);
}