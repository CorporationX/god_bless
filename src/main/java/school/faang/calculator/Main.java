package school.faang.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        int sumResult = AnalyticsProcessor.sum(numbers);
        int productResult = AnalyticsProcessor.product(numbers);

        System.out.println("Sum of numbers: " + sumResult);
        System.out.println("Product of numbers: " + productResult);
    }
}