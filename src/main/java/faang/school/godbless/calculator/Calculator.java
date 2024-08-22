package faang.school.godbless.calculator;

@FunctionalInterface
public interface Calculator<T> {
    T calculate(T input1, T input2);
}