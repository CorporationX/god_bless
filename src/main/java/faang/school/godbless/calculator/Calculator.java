package faang.school.godbless.calculator;

public interface Calculator <T extends Number> {

    T calculate(T firstNumber, T secondNumber);
}
