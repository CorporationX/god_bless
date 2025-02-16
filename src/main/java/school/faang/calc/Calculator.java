package school.faang.calc;

@FunctionalInterface
public interface Calculator<T> {
    T calculator(T a, T b);
}
