package school.faang.calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(calculator.sum(nums));
        System.out.println(calculator.product(nums));
    }
}