package faang.school.godbless.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);

        Long sumResult = CalculatorUtil.sum(numbers);
        Long productResult = CalculatorUtil.product(numbers);

        System.out.printf("The sum of the numbers is: %d\n", sumResult);
        System.out.printf("The product of the numbers is: %d\n", productResult);
    }
}