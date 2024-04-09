package faang.school.godbless.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResourceCalculator dataCalculator = new ResourceCalculator();
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        System.out.println("sum, expected 15");
        System.out.println(dataCalculator.sum(nums));
        System.out.println();

        System.out.println("product, expected 120");
        System.out.println(dataCalculator.product(nums));
    }
}
