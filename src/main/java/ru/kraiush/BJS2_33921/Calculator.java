package ru.kraiush.BJS2_33921;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T firstNumber, T secondNumber);
}
