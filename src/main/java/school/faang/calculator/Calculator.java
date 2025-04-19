package school.faang.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T apply(T a, T b);
}