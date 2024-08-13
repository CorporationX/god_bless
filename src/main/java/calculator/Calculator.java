package calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T performOperation(T a, T b);
}
