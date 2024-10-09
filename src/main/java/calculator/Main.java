package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int resultSum = CalculatorManager.sum(numbers);
        System.out.println("Sum: " + resultSum);

        int resultProduct = CalculatorManager.product(numbers);
        System.out.println("Product: " + resultProduct);
    }
}
