package calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T first, T second);
}
