package faang.school.godbless.module2.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();

        List<Integer> nums = List.of(2, 3, 4, 5);
        System.out.println(calculatorService.multiplication(nums));
        System.out.println(calculatorService.sum(nums));

        List<Integer> invalidNums = List.of(2);

        try {
            System.out.println(calculatorService.multiplication(invalidNums));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculatorService.sum(invalidNums));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
