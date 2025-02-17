package school.faang.calc;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
