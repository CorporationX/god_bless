package faang.school.godbless.BJS2_21493;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumResult = calculatorService.sum(numbers);
        int multiplyResult = calculatorService.multiply(numbers);
        int divideResult = calculatorService.divide(numbers);

        System.out.println("Сумма чисел: " + sumResult);
        System.out.println("Результат умножения: " + multiplyResult);
        System.out.println("Результат деления: " + divideResult);
    }
}
