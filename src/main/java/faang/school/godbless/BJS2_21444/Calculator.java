package faang.school.godbless.BJS2_21444;

@FunctionalInterface
public interface Calculator<T> {
    T compute(T firstNumber, T secondNumber);
}