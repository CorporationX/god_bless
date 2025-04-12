package school.faang.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T valueOne, T valueTwo);
}