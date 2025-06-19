package school.faang.bjs2_80522;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorUtils calculatorUtils = new CalculatorUtils();
        List<Integer> numbers = List.of(1, 5, 6, 7, 1, 3, 66, 10);
        int sumResult = calculatorUtils.sum(numbers);
        int productResult = calculatorUtils.product(numbers);

        System.out.println("Сумма: " + sumResult);
        System.out.println("Произведение: " + productResult);
    }
}
