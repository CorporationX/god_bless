package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T firstNum, T secondNum);
}
