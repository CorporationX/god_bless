package school.faang.calculator.maincode;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T a, T b);
}
