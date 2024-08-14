package faang.school.godbless.BJS2_21456;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List of num is empty");
        }
        int totalValue = nums.get(0);
        for (int num : nums.subList(1, nums.size())) {
            totalValue = calculator.compute(totalValue, num);
        }
        return totalValue;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        System.out.println(product(Arrays.asList(1, 2, 3)));
        System.out.println(sum(Arrays.asList(5, 5, 5)));
    }
}
