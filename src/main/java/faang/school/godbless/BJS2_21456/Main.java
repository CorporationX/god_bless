package faang.school.godbless.BJS2_21456;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, int initValue, Calculator calculator) {
        int totalValue = initValue;
        for (int num : nums) {
            totalValue = calculator.compute(totalValue, num);
        }
        return totalValue;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, 1, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, 0, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        System.out.println(product(Arrays.asList(1, 2, 3)));
        System.out.println(sum(Arrays.asList(5, 5, 5)));
    }
}
