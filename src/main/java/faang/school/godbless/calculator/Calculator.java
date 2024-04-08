package faang.school.godbless.calculator;

public interface Calculator<T extends Number> {
    T operation(T num1, T num2);
}