package faang.school.godbless.sprint_2.calculator;

public interface Calculator<T extends Number> {
    T operation(T num1, T num2);
}