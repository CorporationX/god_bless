package BJS2_5211;

@FunctionalInterface
public interface Calculator<T> {
    T operation(T firstNumber, T secondNumber);
}
