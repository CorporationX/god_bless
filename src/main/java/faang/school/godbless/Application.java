package faang.school.godbless;

import faang.school.godbless.kxnvg.calculator.CalculatorRunner;

import java.util.List;

public class Application {
    public static void main(String... args) {
        List<Integer> nums = List.of(1,2,3,4,5);

        System.out.println(CalculatorRunner.sum(nums));
        System.out.println(CalculatorRunner.product(nums));

    }
}
