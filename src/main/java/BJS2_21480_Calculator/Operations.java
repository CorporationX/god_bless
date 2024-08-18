package BJS2_21480_Calculator;

import java.util.List;

public class Operations {
    public static int calculation(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("The given list is empty!");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculation(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculation(nums, (a, b) -> a * b);
    }
}
