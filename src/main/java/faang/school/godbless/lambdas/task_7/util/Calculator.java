package faang.school.godbless.lambdas.task_7.util;

@FunctionalInterface
public interface Calculator<T, V> {
    V calculate(T firstNumber, T secondNumber);
}