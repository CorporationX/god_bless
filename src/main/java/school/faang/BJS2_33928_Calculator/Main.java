package school.faang.BJS2_33928_Calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sumResult = CalculatorOperations.sum(numbers);
        System.out.println("Sum of numbers: " + sumResult);

        int productResult = CalculatorOperations.product(numbers);
        System.out.println("Product of numbers: " + productResult);
    }
}
