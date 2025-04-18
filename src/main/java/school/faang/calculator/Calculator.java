package school.faang.calculator;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T valueOne, T valueTwo);
}