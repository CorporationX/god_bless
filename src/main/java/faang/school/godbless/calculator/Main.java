package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sumResult = CalculatorUtil.sum(numbers);
        Integer productResult = CalculatorUtil.product(numbers);

        System.out.printf("The sum of the numbers is: %d\n", sumResult);
        System.out.printf("The product of the numbers is: %d\n", productResult);
    }
}