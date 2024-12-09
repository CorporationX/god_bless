package school.faang.task45657;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate(T firstNumber, T secondNumber) throws IllegalArgumentException;
}
